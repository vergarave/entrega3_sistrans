package uniandes.edu.co.proyecto.modelo;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Cita {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fecha;
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "ipsNit", referencedColumnName = "nit")
    private Ips ipsNit;

    @ManyToOne
    @JoinColumn(name = "tipoDocAfiliado", referencedColumnName = "tipoDoc")
    private Afiliado tipoDocAfiliado;

    @ManyToOne
    @JoinColumn(name = "numDocAfiliado", referencedColumnName = "numDoc")
    private Afiliado numDocAfiliado;

    @ManyToOne
    @JoinColumn(name = "ordenServicio", referencedColumnName = "numero")
    private OrdenServicio numOrden;

    public Cita(Integer id, Date fecha, Time hora, Ips ipsNit, Afiliado tipoDocAfiliado, Afiliado numDocAfiliado, 
                OrdenServicio numOrden) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.ipsNit = ipsNit;
        this.tipoDocAfiliado = tipoDocAfiliado;
        this.numDocAfiliado = numDocAfiliado;
        this.numOrden = numOrden;
    }

    public Cita()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Ips getIpsNit() {
        return ipsNit;
    }

    public void setIpsNit(Ips ipsNit) {
        this.ipsNit = ipsNit;
    }

    public Afiliado getTipoDocAfiliado() {
        return tipoDocAfiliado;
    }

    public void setTipoDocAfiliado(Afiliado tipoDocAfiliado) {
        this.tipoDocAfiliado = tipoDocAfiliado;
    }

    public Afiliado getNumDocAfiliado() {
        return numDocAfiliado;
    }

    public void setNumDocAfiliado(Afiliado numDocAfiliado) {
        this.numDocAfiliado = numDocAfiliado;
    }

    public OrdenServicio getNumOrden() {
        return numOrden;
    }

    public void setnumOrden(OrdenServicio numOrden) {
        this.numOrden = numOrden;
    }

    
}
