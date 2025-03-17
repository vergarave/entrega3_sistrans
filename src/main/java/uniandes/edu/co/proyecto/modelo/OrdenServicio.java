package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenesdeservicio")
public class OrdenServicio {
    
    public enum Estado {
        vigente,
        cancelada,
        completada
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;
    private Date fecha;
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "tipoAfiliadoReceptor", referencedColumnName = "tipoDoc")
    private Afiliado tipoAfiliadoReceptor;

    @ManyToOne
    @JoinColumn(name = "numAfiliadoReceptor", referencedColumnName = "numDoc")
    private Afiliado numAfiliadoReceptor;

    @ManyToOne
    @JoinColumn(name = "medicoRemitente", referencedColumnName = "registroMedico")
    private Medico medicoRemitente;

    @ManyToOne
    @JoinColumn(name = "servicioNombre", referencedColumnName = "nombre")
    private ServicioSalud servicioNombre;


    public OrdenServicio(Integer numero, Date fecha, Estado estado, Afiliado tipoAfiliadoReceptor, 
                        Afiliado numAfiliadoReceptor, Medico medicoRemitente, ServicioSalud servicioNombre){
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.tipoAfiliadoReceptor = tipoAfiliadoReceptor;
        this.numAfiliadoReceptor = numAfiliadoReceptor;
        this.medicoRemitente = medicoRemitente;
        this.servicioNombre = servicioNombre;
    }

    public OrdenServicio()
    {;}

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Afiliado getTipoAfiliadoReceptor() {
        return tipoAfiliadoReceptor;
    }

    public void setTipoAfiliadoReceptor(Afiliado tipoAfiliadoReceptor) {
        this.tipoAfiliadoReceptor = tipoAfiliadoReceptor;
    }

    public Afiliado getNumAfiliadoReceptor() {
        return numAfiliadoReceptor;
    }

    public void setNumAfiliadoReceptor(Afiliado numAfiliadoReceptor) {
        this.numAfiliadoReceptor = numAfiliadoReceptor;
    }

    public Medico getMedicoRemitente() {
        return medicoRemitente;
    }

    public void setMedicoRemitente(Medico medicoRemitente) {
        this.medicoRemitente = medicoRemitente;
    }

    public ServicioSalud getServicioNombre() {
        return servicioNombre;
    }

    public void setServicioNombre(ServicioSalud servicioNombre) {
        this.servicioNombre = servicioNombre;
    }
    
}
