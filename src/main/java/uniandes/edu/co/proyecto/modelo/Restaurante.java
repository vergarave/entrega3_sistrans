package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "RESTAURANTE")

public abstract class Restaurante {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private String estilo;
    private Integer capacidad;
    private String nombre;
    private String descripcion;
    private String carta;

    public Restaurante(String estilo, Integer capacidad, String nombre, String descripcion, String carta) {
        this.estilo = estilo;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.carta = carta;
    }

    public Restaurante() 
    {;}

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
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

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    
    
}