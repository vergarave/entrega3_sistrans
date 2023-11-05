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

public class Alojamiento {
    
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
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "planes", referencedColumnName = "idplan")
    private Plan plan;
    @ManyToOne
    @JoinColumn(name = "cuentas", referencedColumnName = "idcuenta")
    private Cuenta cuenta;
    @ManyToOne
    @JoinColumn(name = "habitaciones", referencedColumnName = "idhabitacion")
    private Habitacion habitacion;


    // Constructor
    public Alojamiento(String activa, Date checkin, Date checkout, Integer acompanantes, Usuario usuario, Plan plan, Cuenta cuenta, Habitacion habitacion)
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


    public Alojamiento(){;}


    // Getters
    public Integer getIdalojamiento(){
        return idalojamiento;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public Plan getPlan() {
        return plan;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }


    // Setters
    public void setIdalojamiento(Integer idalojamiento){
        this.idalojamiento = idalojamiento;
    }

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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
}
