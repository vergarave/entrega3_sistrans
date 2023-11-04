package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="piscinas")
@PrimaryKeyJoinColumn(name="idservicio")

public class piscinas extends servicios{

    // Atributos
    private Integer capacidad;
    private Float profundidad;


    // Constructor
    public piscinas(Integer capacidad, Float profundidad,
                    Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
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
