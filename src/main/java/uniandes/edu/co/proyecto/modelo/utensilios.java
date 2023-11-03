package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="utensilios")

public class utensilios extends servicios {

    // Atributos
    private String devuelto;
    private String estado;


    // Constructor
    public utensilios(String devuelto, String estado)
    {
        super();
        this.devuelto = devuelto;
        this.estado = estado;
    }


    public utensilios(){;}


    // Getters
    public String getDevuelto()
    {
        return this.devuelto;
    }

    public String getEstado()
    {
        return this.estado;
    }


    // Setters
    public void setDevuelto(String devuelto)
    {
        this.devuelto = devuelto;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    
}
