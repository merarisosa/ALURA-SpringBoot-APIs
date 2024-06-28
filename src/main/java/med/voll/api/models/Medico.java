package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.ActualizarMedicoDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.enums.Especialidad;

@Table(name = "medico")
@Entity (name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    @Column(name = "isactivo")
    private Boolean isActivo;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(MedicoDTO medico) {
        this.isActivo = true;
        this.nombre = medico.nombre();
        this.email = medico.email();
        this.telefono = medico.telefono();
        this.documento = medico.documento();
        this.especialidad = medico.especialidad();
        this.direccion = new Direccion(medico.direccion());
    }

    public void actualizarDatos(ActualizarMedicoDTO actualizarMedicoDTO) {
        if(actualizarMedicoDTO.nombre() != null){
            this.nombre = actualizarMedicoDTO.nombre();
        }
        if(actualizarMedicoDTO.documento() != null){
            this.documento = actualizarMedicoDTO.documento();
        }
        if(actualizarMedicoDTO.direccion() != null){
            this.direccion = direccion.actualizarDireccion(actualizarMedicoDTO.direccion());
        }
    }

    public void desactivarMedico() {
        this.isActivo = false;
    }
}
