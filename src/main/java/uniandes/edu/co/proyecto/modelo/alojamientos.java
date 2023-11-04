package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="alojamientos")

public class alojamientos {
    
    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idalojamiento;

    private String activa;
    private Date checkin;
    private Date checkout;
    private Integer acompanantes;
    //FK
    @ManyToOne
    @JoinColumn(name = "usuarios", referencedColumnName = "iduser")
    private usuarios usuario;
    @ManyToOne
    @JoinColumn(name = "planes", referencedColumnName = "idplan")
    private planes plan;
    @ManyToOne
    @JoinColumn(name = "cuentas", referencedColumnName = "idcuenta")
    private cuentas cuenta;
    @ManyToOne
    @JoinColumn(name = "habitaciones", referencedColumnName = "idhabitacion")
    private habitaciones habitacion;


    // Constructor
    public alojamientos(String activa, Date checkin, Date checkout, Integer acompanantes, usuarios usuario, planes plan, cuentas cuenta, habitaciones habitacion)
    {
        this.activa = activa;
        this.checkin = checkin;
        this.checkout = checkout;
        this.acompanantes = acompanantes;
        this.usuario = usuario;
        this.plan = plan;
        this.cuenta = cuenta;
        this.habitacion = habitacion;
    }


    public alojamientos(){;}


    // Getters
    public String getActiva() {
        return activa;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer getAcompanantes() {
        return acompanantes;
    }

    public usuarios getUsuario() {
        return usuario;
    }

    public planes getPlan() {
        return plan;
    }

    public cuentas getCuenta() {
        return cuenta;
    }

    public habitaciones getHabitacion() {
        return habitacion;
    }


    // Setters
    public void setActiva(String activa) {
        this.activa = activa;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public void setAcompanantes(Integer acompanantes) {
        this.acompanantes = acompanantes;
    }

    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public void setPlan(planes plan) {
        this.plan = plan;
    }

    public void setCuenta(cuentas cuenta) {
        this.cuenta = cuenta;
    }

    public void setHabitacion(habitaciones habitacion) {
        this.habitacion = habitacion;
    }
    
}
