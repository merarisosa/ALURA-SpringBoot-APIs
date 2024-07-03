package med.voll.api.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleConsultaDTO(
        Long id,

        @NotNull
        Long idPaciente,
        Long idMedico,

        @NotNull
        @Future
        LocalDateTime fecha
) {

    public DetalleConsultaDTO(AgendarConsultaDTO agendarConsultaDTO){
        this(agendarConsultaDTO.id(), agendarConsultaDTO.idPaciente(), agendarConsultaDTO.idMedico(), agendarConsultaDTO.fecha());
    }
}
