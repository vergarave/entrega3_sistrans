package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orden_servicio")
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordenservicio_id;
    
    private Date fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "afiliado_id")
    private Afiliado afiliado;
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "eps_id")
    private Eps eps;

    public OrdenServicio(Date fecha, String estado, Afiliado afiliado, Medico medico, Servicio servicio, Eps eps) {
        this.fecha = fecha;
        this.estado = estado;
        this.afiliado = afiliado;
        this.medico = medico;
        this.servicio = servicio;
        this.eps = eps;
    }

    public Integer getOrdenservicio_id() {
        return ordenservicio_id;
    }

    public void setOrdenservicio_id(Integer ordenservicio_id) {
        this.ordenservicio_id = ordenservicio_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public OrdenServicio(){;}

}
