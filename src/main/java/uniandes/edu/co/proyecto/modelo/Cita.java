package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cita_id;
    
    private Date fecha;
    private Time hora;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "afiliado_id")
    private Afiliado afiliado;
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "ips_id")
    private Ips ips;
    
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    public Cita(Date fecha, Time hora, String estado, Afiliado afiliado, Medico medico, Ips ips, Servicio servicio) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.afiliado = afiliado;
        this.medico = medico;
        this.ips = ips;
        this.servicio = servicio;
    }

    public Integer getCita_id() {
        return cita_id;
    }

    public void setCita_id(Integer cita_id) {
        this.cita_id = cita_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Ips getIps() {
        return ips;
    }

    public void setIps(Ips ips) {
        this.ips = ips;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Cita() {;}
}
