package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "SALONCONFERENCIA")
@PrimaryKeyJoinColumn(name = "id")
public class SalonConferencia extends TipoServicio {

    private double costo;
    private int capacidad;
    private String nombre;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    public SalonConferencia(double costo, int capacidad, String nombre, String descripcion, ReservaServicio reservaServicio) {
        this.costo = costo;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.reservaServicio = reservaServicio;
    }

    public SalonConferencia() {;}

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}
