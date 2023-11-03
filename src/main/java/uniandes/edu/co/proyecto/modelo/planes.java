package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planes")

public class planes {
    
    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idplan;

    private String tipoplan;
    private Float descuento;
    

    // Constructor
    public planes(String tipoplan, Float descuento, Integer idplan)
    {
        this.tipoplan = tipoplan;
        this.descuento = descuento;
        this.idplan = idplan;
    }


    public planes(){;}


    // Getters
    public String getTipoplan() {
        return tipoplan;
    }

    public Float getDescuento() {
        return descuento;
    }

    public Integer getIdplan() {
        return idplan;
    }

    
    // Setters
    public void setTipoplan(String tipoplan) {
        this.tipoplan = tipoplan;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }
    
}
