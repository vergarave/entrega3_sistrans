package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenesdeservicio")
public class OrdenServicio {
    
    enum Estado {
        vigente,
        cancelada,
        completada
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;
    private Date fecha;
    private Estado estado;

    public OrdenServicio(Integer numero, Date fecha, Estado estado){
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
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

    
}
