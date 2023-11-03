package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="spas")
public class spas {

    // Atributos
    private Integer capacidad;


    // Constructor
    public spas(Integer capacidad)
    {
        super();
        this.capacidad = capacidad;
    }


    public spas(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }


    // Setters
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}
