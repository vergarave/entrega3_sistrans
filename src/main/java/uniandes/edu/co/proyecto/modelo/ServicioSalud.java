package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosdesalud")
public class ServicioSalud {
    
    enum TipoServicio{
        consultaGeneral,
        consultaEspecialista,
        consultaControl,
        consultaUrgencia,
        examenDiagnostico,
        terapia
    }

    @Id
    private String nombre;
    private String descripcion;
    private TipoServicio tipoServicio;
    
    @ManyToOne
    @JoinColumn(name = "ipsOfrecida", referencedColumnName = "nit")
    private Ips ipsOfrecida;

    public ServicioSalud(String nombre, String descripcion, TipoServicio tipoServicio, Ips ipsOfrecida){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoServicio = tipoServicio;
        this.ipsOfrecida = ipsOfrecida;
    }

    public ServicioSalud()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Ips getIpsOfrecida() {
        return ipsOfrecida;
    }

    public void setIpsOfrecida(Ips ipsOfrecida) {
        this.ipsOfrecida = ipsOfrecida;
    }

    
}
