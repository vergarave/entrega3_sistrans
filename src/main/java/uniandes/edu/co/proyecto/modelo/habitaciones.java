package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")

public class habitaciones {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhabitacion;

    private Integer numhabitacion;
    private String disponible;
    private Integer precionoche;
    //FK
    @ManyToOne
    @JoinColumn(name="hoteles", referencedColumnName = "idhotel")
    private hoteles hotel;
    @ManyToOne
    @JoinColumn(name="tipos", referencedColumnName = "idtipo")
    private tipos tipo;
    @ManyToOne
    @JoinColumn(name = "alojamientos", referencedColumnName = "idalojamiento")
    private alojamientos alojamiento;


    // Constructor
    public habitaciones(Integer numhabitacion, String disponible, Integer precionoche, hoteles hotel, tipos tipo, alojamientos alojamiento)
    {
        this.numhabitacion = numhabitacion;
        this.disponible = disponible;
        this.precionoche = precionoche;
        this.hotel = hotel;
        this.tipo = tipo;
        this.alojamiento = alojamiento;
    }


    public habitaciones(){;}


    // Getters
    public Integer getIdhabitacion(){
        return idhabitacion;
    }

    public Integer getNumhabitacion() {
        return numhabitacion;
    }

    public String getDisponible() {
        return disponible;
    }

    public Integer getPrecionoche() {
        return precionoche;
    }

    public hoteles getHotel() {
        return hotel;
    }

    public tipos getTipo() {
        return tipo;
    }

    public alojamientos getAlojamiento() {
        return alojamiento;
    }


    // Setters
    public void setIdhabitacion(Integer idhabitacion){
        this.idhabitacion = idhabitacion;
    }
    
    public void setNumhabitacion(Integer numhabitacion) {
        this.numhabitacion = numhabitacion;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public void setPrecionoche(Integer precionoche) {
        this.precionoche = precionoche;
    }

    public void setHotel(hoteles hotel) {
        this.hotel = hotel;
    }

    public void setTipo(tipos tipo) {
        this.tipo = tipo;
    }

    public void setAlojamiento(alojamientos alojamiento) {
        this.alojamiento = alojamiento;
    }

}
