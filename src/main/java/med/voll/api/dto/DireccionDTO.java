package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;

@NotBlank
public record DireccionDTO(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
) {
}
