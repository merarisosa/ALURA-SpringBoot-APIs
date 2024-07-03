package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record ActualizarMedicoDTO(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DireccionDTO direccion
) {
}
