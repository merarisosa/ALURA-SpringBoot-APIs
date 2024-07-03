package med.voll.api.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendarConsultaDTO(
        Long id,

        @NotNull
        Long idPaciente,
        Long idMedico,

        @NotNull
        @Future
        LocalDateTime fecha
) {

    public AgendarConsultaDTO(DetalleConsultaDTO detalleConsultaDTO){
        this(detalleConsultaDTO.id(), detalleConsultaDTO.idPaciente(), detalleConsultaDTO.idMedico(), detalleConsultaDTO.fecha());
    }
}
