package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "SPA")
public class Spa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "spa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServicioSpa> servicios;

    @OneToOne
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    public Spa(String nombre, String descripcion, List<ServicioSpa> servicios, ReservaServicio reservaServicio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.servicios = servicios;
        this.reservaServicio = reservaServicio;
    }

    public Spa() {;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ServicioSpa> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioSpa> servicios) {
        this.servicios = servicios;
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}

