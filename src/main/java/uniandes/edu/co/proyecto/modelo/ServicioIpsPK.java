package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ServicioIpsPK implements Serializable{
    
    @Column(name = "NOMBRESERVICIO")
    private String nombreServicio;

    @Column(name = "NITIPS")
    private String nitIps;

    public ServicioIpsPK() {;}

    public ServicioIpsPK(String nombreServicio, String nitIps) {
        this.nombreServicio = nombreServicio;
        this.nitIps = nitIps;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNitIps() {
        return nitIps;
    }

    public void setNitIps(String nitIps) {
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
