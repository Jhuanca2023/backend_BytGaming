package gaming.pe.DTOs.auth;

import jakarta.validation.constraints.NotBlank;

public record  AuthLoginRequestDto(@NotBlank String username,
                                   @NotBlank String password) {
}
