package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro {
    @EmbeddedId
    private RegistroPK registroPK;

    public Registro(RegistroPK registroPK) {
        this.registroPK = registroPK;
    }

    public Registro() {
        ;
    }

    public RegistroPK getRegistroPK() {
        return registroPK;
    }

    public void setRegistroPK(RegistroPK registroPK) {
        this.registroPK = registroPK;
    }

}