package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOSERVICIO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TipoServicio {

    @Id
    private String nombre;

    public TipoServicio() {
    }

    public TipoServicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

