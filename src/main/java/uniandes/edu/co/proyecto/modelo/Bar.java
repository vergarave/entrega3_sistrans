package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "BAR")
@PrimaryKeyJoinColumn(name = "id")
public class Bar extends TipoServicio {

    private String estilo;
    private int capacidad;
    private String nombre;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    @OneToOne
    private Carta carta;

    public Bar(String estilo, int capacidad, String nombre, String descripcion, Carta carta, ReservaServicio reservaServicio) {
        this.estilo = estilo;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.carta = carta;
        this.reservaServicio = reservaServicio;
    }

    public Bar() {
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
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

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}
