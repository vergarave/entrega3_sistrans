package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")

public class internet {
    
    // Atributos
    private Integer anchobanda;
    

    // Constructor
    public internet(Integer anchobanda)
    {
        super();
        this.anchobanda = anchobanda;
    }


    public internet(){;}


    // Getters
    public Integer getAnchobanda() {
        return anchobanda;
    }


    // Setters
    public void setAnchobanda(Integer anchobanda) {
        this.anchobanda = anchobanda;
    }
    
}
