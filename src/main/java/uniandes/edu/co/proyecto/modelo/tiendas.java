package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="tiendas")
@PrimaryKeyJoinColumn(name="idservicio")

public class tiendas extends servicios{
    
    // Atributos
    private String tipo;
    

    // Constructor
    public tiendas(String tipo,
                    Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.tipo = tipo;
    }


    public tiendas(){;}


    // Getters
    public String getTipo()
    {
        return this.tipo;
    }


    // Setters
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

}
