package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table (name = "GIMNASIO")
public abstract class Gimnasio {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer nombre;
    private String maquinas;
    private String horario;
    private Integer capacidad;
    private String descripcion;

    public Gimnasio(Integer nombre, String maquinas, String horario, Integer capacidad, String descripcion) {
        this.nombre = nombre;
        this.maquinas = maquinas;
        this.horario = horario;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public Gimnasio() 
    {;}

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
