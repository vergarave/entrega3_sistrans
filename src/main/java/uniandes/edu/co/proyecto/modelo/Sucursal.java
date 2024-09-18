package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
@Table(name="sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Double tamanio;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name="codigo_Ciudad", referencedColumnName="id")
    private Ciudad codigoCiudad;
    
    public Sucursal(String nombre, Double tamanio, String direccion,
                     String telefono, Ciudad codigoCiudad)
    {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigoCiudad = codigoCiudad;
    }

    public Sucursal()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ciudad getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Ciudad codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }



    
}
