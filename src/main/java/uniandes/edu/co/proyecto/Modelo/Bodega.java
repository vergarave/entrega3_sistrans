package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;

    private Integer tamaño;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal_id;

    public Bodega(String nombre, Integer tamaño, Sucursal sucursal_id)
    {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.sucursal_id = sucursal_id;
    }

    public Bodega()
    {
        ;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public Sucursal getSucursal_id() {
        return sucursal_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public void setSucursal_id(Sucursal sucursal_id) {
        this.sucursal_id = sucursal_id;
    }
}
