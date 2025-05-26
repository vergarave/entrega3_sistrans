package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ips")
public class Ips {

    private String nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> servicios; // códigos de servicios

    public Ips(String nit, String nombre, String direccion, String telefono, List<String> servicios) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.servicios = servicios;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }
}
