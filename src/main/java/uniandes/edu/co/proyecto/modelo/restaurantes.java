package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurantes")

public class restaurantes {

    // Atributos
    private String estilo;


    // Constructor
    public restaurantes(String estilo)
    {
        super();
        this.estilo = estilo;
    }


    public restaurantes(){;}


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
