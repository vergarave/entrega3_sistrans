package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "HABITACION")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

    private String cuenta;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion_id")
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "reserva_alojamiento_id")
    private ReservaAlojamiento reservaAlojamiento;

    public Habitacion(Long numero, String cuenta, TipoHabitacion tipoHabitacion) {
        this.numero = numero;
        this.cuenta = cuenta;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion() {;}

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public ReservaAlojamiento getReservaAlojamiento() {
        return reservaAlojamiento;
    }

    public void setReservaAlojamiento(ReservaAlojamiento reservaAlojamiento) {
        this.reservaAlojamiento = reservaAlojamiento;
    }
}
