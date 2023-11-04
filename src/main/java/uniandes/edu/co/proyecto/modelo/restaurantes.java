package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="restaurantes")
@PrimaryKeyJoinColumn(name="idservicio")

public class restaurantes extends servicios{

    // Atributos
    private String estilo;


    // Constructor
    public restaurantes(String estilo, 
                        Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.estilo = estilo;
    }


    public restaurantes(){;}


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
