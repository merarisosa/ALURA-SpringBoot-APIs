package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

@NotNull
public record DireccionDTO(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
) {
}
