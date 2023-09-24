package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALON_DE_REUNIONES")

public class SalonDeReuniones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer costo;
    private Integer capacidad;
    private String nombre;
    private String descripcion;

    public SalonDeReuniones(Integer costo, Integer capacidad, String nombre, String descripcion) {
        this.costo = costo;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public SalonDeReuniones() 
    {;}

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
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

    
    
}
