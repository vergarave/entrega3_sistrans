package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")

public class hoteles {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhotel;

    private String nombrehotel;
    private Integer nithotel;
    
    
    // Constructor
    public hoteles(String nombrehotel, Integer nithotel, Integer idhotel)
    {
        this.nombrehotel = nombrehotel;
        this.nithotel = nithotel;
        this.idhotel = idhotel;
    }


    public hoteles(){;}


    // Getters
    public String getNombrehotel() {
        return nombrehotel;
    }

    public Integer getNithotel() {
        return nithotel;
    }

    public Integer getIdhotel() {
        return idhotel;
    }

    
    // Setters
    public void setNombrehotel(String nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    public void setNithotel(Integer nithotel) {
        this.nithotel = nithotel;
    }

    public void setIdhotel(Integer idhotel) {
        this.idhotel = idhotel;
    }

}
