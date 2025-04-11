package gaming.pe.DTOs.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequestDto(@NotBlank String username,
                                       @NotBlank String password,
                                       @Valid AuthResponseRegisterDto roleRequest) {
}