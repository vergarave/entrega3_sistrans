package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="restaurantes")
@PrimaryKeyJoinColumn(name="idservicio")

public class Restaurante extends Servicio{

    // Atributos
    private String estilo;


    // Constructor
    public Restaurante(String estilo, 
                        Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, Reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.estilo = estilo;
    }


    public Restaurante(){;}


    // Getters
    public String getEstilo()
    {
        return this.estilo;
    }


    // Setters
    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }
    
}
