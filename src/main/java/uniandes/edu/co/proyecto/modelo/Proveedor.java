package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {

    private String nit;
    private String nombre;
    private String direccion;
    private String nombrePersonaContacto;
    private String telefonoPersonaContacto;

    public Proveedor(String nit, String nombre, String direccion, 
                        String nombrePersonaContacto, 
                        String telefonoPersonaContacto)
    {   
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombrePersonaContacto = nombrePersonaContacto;
        this.telefonoPersonaContacto = telefonoPersonaContacto;
    }

    public Proveedor()
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombrePersonaContacto() {
        return nombrePersonaContacto;
    }

    public void setNombrePersonaContacto(String nombrePersonaContacto) {
        this.nombrePersonaContacto = nombrePersonaContacto;
    }

    public String getTelefonoPersonaContacto() {
        return telefonoPersonaContacto;
    }

    public void setTelefonoPersonaContacto(String telefonoPersonaContacto) {
        this.telefonoPersonaContacto = telefonoPersonaContacto;
    }

    
    
}

