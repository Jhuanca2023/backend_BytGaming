package gaming.pe.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record  AuthLoginRequestDto(@NotBlank @Email String email,
                                   @NotBlank String password){
        }
