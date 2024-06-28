package med.voll.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.enums.Especialidad;
import med.voll.api.models.Medico;

public record MedicoInfoDTO(
        Long id,

        @NotBlank
        String nombre,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefono,

        @NotNull
        Especialidad especialidad
) {

        public MedicoInfoDTO(Medico medico){
                this(medico.getId(),
                        medico.getNombre(),
                        medico.getEmail(),
                        medico.getTelefono(),
                        medico.getEspecialidad());
        }
}
