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
@Table(name="reservas")

public class reserva {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreserva;
    
    private Date horareserva;
    //FK
    @ManyToOne
    @JoinColumn(name = "cuentas", referencedColumnName = "idcuentas")
    private cuentas cuenta;


    // Constructor
    public reserva(Date horareserva, Integer idreserva, cuentas cuenta)
    {
        this.horareserva = horareserva;
        this.idreserva = idreserva;
        this.cuenta = cuenta;
    }


    public reserva(){;}


    // Getters
    public Date getHorareserva() {
        return horareserva;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public cuentas getCuenta() {
        return cuenta;
    }


    // Setters
    public void setHorareserva(Date horareserva) {
        this.horareserva = horareserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public void setCuenta(cuentas cuenta) {
        this.cuenta = cuenta;
    }
    
}
