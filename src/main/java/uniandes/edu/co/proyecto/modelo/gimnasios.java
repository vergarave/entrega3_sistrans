package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")
public class gimnasios {
    
    // Atributos
    private Integer capacidad;
    private String maquinas;


    // Constructor
    public gimnasios(Integer capacidad, String maquinas)
    {
        super();
        this.capacidad = capacidad;
        this.maquinas = maquinas;
    }


    public gimnasios(){;}


    // Getters
    public Integer getCapacidad() {
        return capacidad;
    }

    public String getMaquinas() {
        return maquinas;
    }


    // Setters
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }
    
}
