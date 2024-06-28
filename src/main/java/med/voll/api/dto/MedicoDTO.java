package med.voll.api.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidad;

public record MedicoDTO (
        @NotBlank
        String nombre,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefono,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento,

        @NotNull
        Especialidad especialidad,

        @Valid
        @NotNull
        DireccionDTO direccion
){
}
