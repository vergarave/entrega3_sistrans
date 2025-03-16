package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioIpsPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "nombreServicio", referencedColumnName = "nombre")
    private ServicioSalud nombreServicio;

    @ManyToOne
    @JoinColumn(name = "nitIps", referencedColumnName = "nit")
    private Ips nitIps;

    public ServicioIpsPK() {
    }

    public ServicioIpsPK(ServicioSalud nombreServicio, Ips nitIps) {
        this.nombreServicio = nombreServicio;
        this.nitIps = nitIps;
    }

    public ServicioSalud getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(ServicioSalud nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Ips getNitIps() {
        return nitIps;
    }

    public void setNitIps(Ips nitIps) {
        this.nitIps = nitIps;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServicioIpsPK that = (ServicioIpsPK) obj;
        return Objects.equals(nombreServicio, that.nombreServicio) &&
               Objects.equals(nitIps, that.nitIps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreServicio, nitIps);
    }
    
}
