package gaming.pe.Service;

import gaming.pe.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UsersMetodos {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);

    UserEntity save(UserEntity user);
    void deleteById(Long id);
}
