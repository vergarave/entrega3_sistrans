package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="tiendas")
@PrimaryKeyJoinColumn(name="idservicio")

public class Tienda extends Servicio {
    
    // Atributos
    private String tipo;
    

    // Constructor
    public Tienda(String tipo,
                    Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, Reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.tipo = tipo;
    }


    public Tienda(){;}


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
