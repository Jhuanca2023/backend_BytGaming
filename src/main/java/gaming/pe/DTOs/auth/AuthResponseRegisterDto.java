package gaming.pe.DTOs.auth;

import jakarta.validation.constraints.Size;

import java.util.List;

public record AuthResponseRegisterDto(
        @Size(max = 3, message = "The user cannot have more than 3 roles") String roleListName) {
}
