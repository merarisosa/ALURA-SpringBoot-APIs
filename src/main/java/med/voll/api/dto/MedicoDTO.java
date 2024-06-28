package med.voll.api.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidad;

public record MedicoDTO (

        Long id,

        @NotNull
        String nombre,

        @NotNull
        @Email
        String email,

        @NotNull
        String telefono,

        @NotNull
        @Pattern(regexp = "\\d{4,6}")
        String documento,

        @NotNull
        Especialidad especialidad,

        @Valid
        @NotNull
        DireccionDTO direccion
){
}
