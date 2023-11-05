package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="conferencias")
@PrimaryKeyJoinColumn(name="idservicio")

public class Conferencia extends Servicio {

    // Atributos
    private Integer capacidad;
    private Date fecha;
    private Time hora;
    private Integer duracion;


    // Constructor
    public Conferencia(Integer capacidad, Date fecha, Time hora, Integer duracion, 
                        Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, Reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }


    public Conferencia(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public Integer getDuracion() {
        return duracion;
    }


    // Setters
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

}
