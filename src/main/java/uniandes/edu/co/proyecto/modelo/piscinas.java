package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")

public class piscinas {

    // Atributos
    private Integer capacidad;
    private Float profundidad;


    // Constructor
    public piscinas(Integer capacidad, Float profundidad)
    {
        super();
        this.capacidad = capacidad;
        this.profundidad = profundidad;
    }


    public piscinas(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getProfundidad() {
        return profundidad;
    }


    // Setters
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }
    
}
