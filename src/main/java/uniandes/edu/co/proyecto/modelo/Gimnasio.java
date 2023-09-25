package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GIMNASIO")
public class Gimnasio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int maquinas;
    private String horario;
    private int capacidad;
    private String nombre;
    private String descripcion;

    @ManyToOne
    private ReservaServicio reservaServicio;

    public Gimnasio(int maquinas, String horario, int capacidad, String nombre, String descripcion, ReservaServicio reservaServicio) {
        this.maquinas = maquinas;
        this.horario = horario;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.reservaServicio = reservaServicio;
    }

    public Gimnasio() {;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(int maquinas) {
        this.maquinas = maquinas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
