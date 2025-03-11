package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eps")
public class Eps {
    @Id
    private String nit;
    private String nombre;

    public Eps(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }

    public Eps()
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

    

}
