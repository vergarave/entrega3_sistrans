package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private Double tamanio;
    private Double porcentajeOcupacion;
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name="id_sucursal", referencedColumnName="id")
    private Sucursal idSucursal;

    public Bodega(String nombre, Double tamanio, Double porcentajeOcupacion, Integer capacidad, Sucursal idSucursal){
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.porcentajeOcupacion = porcentajeOcupacion;
        this.capacidad = capacidad;
        this.idSucursal = idSucursal;
    }

    public Bodega(){
    ;}

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public Double getPorcentajeOcupacion() {
        return porcentajeOcupacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public void setPorcentajeOcupacion(Double porcentajeOcupacion) {
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    
}
