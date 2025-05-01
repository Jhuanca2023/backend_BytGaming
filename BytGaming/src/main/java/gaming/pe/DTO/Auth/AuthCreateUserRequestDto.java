package gaming.pe.DTO.Auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequestDto(@NotBlank String email ,
                                       @NotBlank String password,
                                       @Valid AuthResponseRegisterDto roleRequest){
        }