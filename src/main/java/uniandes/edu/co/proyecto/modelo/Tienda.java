package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "TIENDA")
@PrimaryKeyJoinColumn(name = "id")
public class Tienda extends TipoServicio {

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @OneToOne
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    public Tienda(String nombre, String descripcion, List<Producto> productos, ReservaServicio reservaServicio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
        this.reservaServicio = reservaServicio;
    }

    public Tienda() {;}

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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}

