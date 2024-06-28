package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.Medico;

public record EliminarMedicoDTO(
        @NotNull
        Long id
) {
}
