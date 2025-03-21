package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="historial_citas")
public class HistorialCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer historialCitas_id;

    @ManyToOne
    @JoinColumn(name = "afiliado_id")
    private Afiliado afiliado;
    
    @ManyToOne
    @JoinColumn(name = "cita_id")
    private Cita cita;
    
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenServicio ordenServicio;

    public HistorialCitas(Afiliado afiliado, Cita cita, OrdenServicio ordenServicio) {
        this.afiliado = afiliado;
        this.cita = cita;
        this.ordenServicio = ordenServicio;
    }

    public Integer getHistorialCitas_id() {
        return historialCitas_id;
    }

    public void setHistorialCitas_id(Integer historialCitas_id) {
        this.historialCitas_id = historialCitas_id;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

}
