package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.Direccion;

public record ActualizarMedicoDTO(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DireccionDTO direccion
) {
}
