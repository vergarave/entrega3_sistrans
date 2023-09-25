package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOTELANDES")
public class HotelAndes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "hotelAndes")
    private List<Servicio> servicios;

    @OneToMany(mappedBy = "hotelAndes")
    private List<Habitacion> habitaciones;

    @OneToMany(mappedBy = "hotelAndes")
    private List<Usuario> usuarios;

    private Date fecha;

    public HotelAndes() {;}

    public HotelAndes(List<Servicio> servicios, List<Habitacion> habitaciones, List<Usuario> usuarios, Date fecha) {
        this.servicios = servicios;
        this.habitaciones = habitaciones;
        this.usuarios = usuarios;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
