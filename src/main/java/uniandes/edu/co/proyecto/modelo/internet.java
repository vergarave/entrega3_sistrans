package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="internet")
@PrimaryKeyJoinColumn(name="idservicio")

public class internet extends servicios{
    
    // Atributos
    private Integer anchobanda;
    

    // Constructor
    public internet(Integer anchobanda,
                    Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.anchobanda = anchobanda;
    }


    public internet(){;}


    // Getters
    public Integer getAnchobanda() {
        return anchobanda;
    }


    // Setters
    public void setAnchobanda(Integer anchobanda) {
        this.anchobanda = anchobanda;
    }
    
}
