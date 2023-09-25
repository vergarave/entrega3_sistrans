package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "INTERNET")
@PrimaryKeyJoinColumn(name = "id")
public class Internet extends TipoServicio {

    private boolean costoIncluido;
    private int capacidad;
    private String nombre;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    public Internet(boolean costoIncluido, int capacidad, String nombre, String descripcion, ReservaServicio reservaServicio) {
        this.costoIncluido = costoIncluido;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.reservaServicio = reservaServicio;
    }

    public Internet() {
    }

    public boolean isCostoIncluido() {
        return costoIncluido;
    }

    public void setCostoIncluido(boolean costoIncluido) {
        this.costoIncluido = costoIncluido;
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
