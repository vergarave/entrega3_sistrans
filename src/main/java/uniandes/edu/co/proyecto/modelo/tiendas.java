package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")

public class tiendas {
    
    // Atributos
    private String tipo;
    

    // Constructor
    public tiendas(String tipo)
    {
        super();
        this.tipo = tipo;
    }


    public tiendas(){;}


    // Getters
    public String getTipo()
    {
        return this.tipo;
    }


    // Setters
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

}
