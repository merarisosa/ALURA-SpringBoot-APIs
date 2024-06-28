package med.voll.api.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DireccionDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public Direccion(DireccionDTO direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }

    public Direccion actualizarDireccion(DireccionDTO direccion) {
        if(direccion.calle() !=null){
            this.calle = direccion.calle();
        }
        if(direccion.distrito() !=null){
            this.distrito = direccion.distrito();
        }
        if(direccion.ciudad() !=null){
            this.ciudad = direccion.ciudad();
        }
        if(direccion.numero() !=null){
            this.numero = direccion.numero();
        }
        if(direccion.complemento() !=null){
            this.complemento = direccion.complemento();
        }
        return this;
    }
}
