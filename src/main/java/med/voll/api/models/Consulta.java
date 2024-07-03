package med.voll.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import med.voll.api.dto.AgendarConsultaDTO;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "paciente_id")
    private Paciente idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "medico_id")
    private Medico idMedico;

    @NotNull
    @Future
    private LocalDateTime fecha;

}
