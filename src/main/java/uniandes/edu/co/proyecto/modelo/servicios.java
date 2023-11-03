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
@Table(name="servicios")

public class servicios {
    
    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idservicio;

    private Date horarioinicio;
    private Date horariofin;
    private String nombre;
    private Integer costo;
    private String cargado;
    private String existe;
    //FK
    @ManyToOne
    @JoinColumn(name="reservas", referencedColumnName = "idreserva")
    private reserva reserva;


    // Constructor
    public servicios(Date horarioinicio, Date horariofin, String nombre, Integer costo, String cargado, String existe, Integer idservicio, reserva reserva)
    {
        this.horarioinicio = horarioinicio;
        this.horariofin = horariofin;
        this.nombre = nombre;
        this.costo = costo;
        this.cargado = cargado;
        this.existe = existe;
        this.idservicio = idservicio;
        this.reserva = reserva;
    }


    public servicios(){;}


    // Getters
    public Date getHorarioinicio() {
        return horarioinicio;
    }

    public Date getHorariofin() {
        return horariofin;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public String getCargado() {
        return cargado;
    }

    public String getExiste() {
        return existe;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public reserva getReserva() {
        return reserva;
    }


    // Setters
    public void setHorarioinicio(Date horarioinicio) {
        this.horarioinicio = horarioinicio;
    }

    public void setHorariofin(Date horariofin) {
        this.horariofin = horariofin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setCargado(String cargado) {
        this.cargado = cargado;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public void setReserva(reserva reserva) {
        this.reserva = reserva;
    }
    
}
