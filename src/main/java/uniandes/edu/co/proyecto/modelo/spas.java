package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="spas")
@PrimaryKeyJoinColumn(name="idservicio")

public class spas extends servicios {

    // Atributos
    private Integer capacidad;


    // Constructor
    public spas(Integer capacidad, 
                Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
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
