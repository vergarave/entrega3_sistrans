package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="reuniones")
@PrimaryKeyJoinColumn(name="idservicio")

public class Reunion extends Servicio {

    // Atributos
    private Integer capacidad;
    private Integer costoadicional;
    private Date fecha;
    private Time hora;
    private Integer duracion;


    // Constructor
    public Reunion(Integer capacidad, Integer costoadicional, Date fecha, Time hora, Integer duracion, 
                    Time horarioinicio, Time horariofin, String nombre, Integer costo, String cargado, String existe, Reserva reserva)
    {
        super(horarioinicio, horariofin, nombre, costo, cargado, existe, reserva);
        this.capacidad = capacidad;
        this.costoadicional = costoadicional;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }


    public Reunion(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCostoadicional() {
        return costoadicional;
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

    public void setCostoadicional(Integer costoadicional) {
        this.costoadicional = costoadicional;
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
