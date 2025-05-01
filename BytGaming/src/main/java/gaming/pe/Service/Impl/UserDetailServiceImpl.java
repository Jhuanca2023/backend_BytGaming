package gaming.pe.Service.Impl;


import gaming.pe.DTO.Auth.AuthCreateUserRequestDto;
import gaming.pe.DTO.Auth.AuthLoginRequestDto;
import gaming.pe.DTO.Auth.AuthResponseDto;
import gaming.pe.Entity.RoleEntity;
import gaming.pe.Entity.UserEntity;
import gaming.pe.Enums.RoleEnum;
import gaming.pe.Repository.RoleRepository;
import gaming.pe.Repository.UsersRepository;
import gaming.pe.config.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        UserEntity userEntity = userRepository.findUserEntitiesByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario  con email" + email + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        authorityList.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().getRoleEnum().name()));
        //new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().getRoleEnum().name()) ;
        //userEntity.getRole() .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

//        userEntity.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));


        return new User(userEntity.getEmail(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorityList);
    }
    public AuthResponseDto createUser(AuthCreateUserRequestDto request) throws BadRequestException {
        String email = request.email();
        String password = request.password();

        // El rol siempre debe ser USER
        RoleEnum defaultRoleEnum = RoleEnum.USER;

        // Obtener el rol por defecto de la base de datos
        Optional<RoleEntity> optionalRole = roleRepository.findByRoleEnum(defaultRoleEnum);
        if (optionalRole.isEmpty()) {
            throw new BadCredentialsException("Invalid email or password");
        }

        RoleEntity role = optionalRole.get();

        // Crear y guardar el usuario con el rol por defecto
        UserEntity userEntity = UserEntity.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        UserEntity userSaved = userRepository.save(userEntity);

        // Crear authorities
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userSaved.getRole().getRoleEnum().name()));

        // Autenticar al usuario (opcional)
        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generar token JWT
        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponseDto(email, "User created successfully", accessToken, true);
    }


    public AuthResponseDto loginUser(AuthLoginRequestDto authLoginRequest) {

        String email = authLoginRequest.email();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(email, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new AuthResponseDto(email, "User loged succesfully", accessToken, true);
    }

    public Authentication authenticate(String email, String password) {
        UserDetails userDetails = this.loadUserByUsername(email);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid email or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(email, password, userDetails.getAuthorities());
    }
}
