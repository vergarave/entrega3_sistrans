package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios_spas")

public class servicios_spas {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idservispas;

    private Integer duracion;
    private Integer costo;
    private Date fecha;
    //FK
    @ManyToOne
    @JoinColumn(name="spas", referencedColumnName = "idservicio")
    private spas spa;


    // Constructor
    public servicios_spas(Integer duracion, Integer costo, Date fecha, Integer idservispas, spas spa)
    {
        this.duracion = duracion;
        this.costo = costo;
        this.fecha = fecha;
        this.idservispas = idservispas;
        this.spa = spa;
    }


    public servicios_spas(){;}


    // Getters
    public Integer getDuracion() {
        return duracion;
    }

    public Integer getCosto() {
        return costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Integer getIdservispas() {
        return idservispas;
    }

    public spas getSpa() {
        return spa;
    }


    // Setters
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdservispas(Integer idservispas) {
        this.idservispas = idservispas;
    }

    public void setSpa(spas spa) {
        this.spa = spa;
    }
    
}
