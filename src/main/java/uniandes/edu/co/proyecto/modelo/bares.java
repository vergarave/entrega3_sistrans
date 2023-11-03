package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="bares")
public class bares extends servicios {

    // Atributos
    private String estilo;


    // Constructor
    public bares(String estilo)
    {
        super();
        this.estilo = estilo;
    }


    public bares(){;}


    // Getters
    public String getEstilo()
    {
        return this.estilo;
    }


    // Setters
    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }

}
