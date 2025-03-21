package uniandes.edu.co.proyecto.modelo;

import java.util.List;
import uniandes.edu.co.proyecto.modelo.Ips;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicio {
    public Servicio(String nombre, String descripcion, String tipo, List<Cita> citas, List<Receta> recetas,
            List<Ips> ips) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.citas = citas;
        this.recetas = recetas;
        this.ips = ips;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer servicio_id;
    
    private String nombre;
    private String descripcion;
    private String tipo;
    
    @OneToMany(mappedBy = "servicio")
    private List<Cita> citas;
    
    @OneToMany(mappedBy = "servicio")
    private List<Receta> recetas;

    @ManyToMany(mappedBy = "servicios")
    private List<Ips> ips;

    public Integer getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Integer servicio_id) {
        this.servicio_id = servicio_id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public List<Ips> getIps() {
        return ips;
    }

    public void setIps(List<Ips> ips) {
        this.ips = ips;
    }

    public Servicio() {;}
}