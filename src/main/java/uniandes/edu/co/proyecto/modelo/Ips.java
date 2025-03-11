package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ips")
public class Ips {
    
    @Id
    private String nit;
    private String nombre;
    private String ciudad;
    private String direccion;
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "epsNit", referencedColumnName = "nit")
    private Eps epsNit;

    public Ips(String nit, String nombre, String ciudad, String direccion, Integer telefono, Eps epsNit){
        this.nit = nit;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.epsNit = epsNit;
    }

    public Ips()
        {;}

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Eps getEpsNit() {
        return epsNit;
    }

    public void setEpsNit(Eps epsNit) {
        this.epsNit = epsNit;
    }

}
