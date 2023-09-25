package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;

    private String documento;
    private String nombre;
    private String correo;
    private String rol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_alojamiento_id")
    private ReservaAlojamiento reservaAlojamiento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_servicio_id")
    private ReservaServicio reservaServicio;

    public Usuario(String documento, String nombre, String correo, String rol, ReservaAlojamiento reservaAlojamiento, ReservaServicio reservaServicio) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.reservaAlojamiento = reservaAlojamiento;
        this.reservaServicio = reservaServicio;
    }

    public Usuario() {;}

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ReservaAlojamiento getReservaAlojamiento() {
        return reservaAlojamiento;
    }

    public void setReservaAlojamiento(ReservaAlojamiento reservaAlojamiento) {
        this.reservaAlojamiento = reservaAlojamiento;
    }

    public ReservaServicio getReservaServicio() {
        return reservaServicio;
    }

    public void setReservaServicio(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }
}
