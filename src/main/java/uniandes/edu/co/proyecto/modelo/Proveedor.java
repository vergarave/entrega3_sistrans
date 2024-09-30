package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Clase que mapea la tabla Proveedor en la base de datos
@Entity
@Table(name="proveedor")
public class Proveedor {

    //Atributos de la clase
    @Id
    private String nit; //Indica que es la llave primaria asignada por el usuario

    //Atributos de la clase
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

