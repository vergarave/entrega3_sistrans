package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIOSIPS")
public class ServicioIps {
    
    @EmbeddedId
    private ServicioIpsPK pk;
    
    @ManyToOne
    @MapsId("nombreServicio")
    @JoinColumn(name = "NOMBRESERVICIO", referencedColumnName = "NOMBRE")
    private ServicioSalud servicioSalud;

    @ManyToOne
    @MapsId("nitIps")
    @JoinColumn(name = "NITIPS", referencedColumnName = "NIT")
    private Ips ips;

    public ServicioIps(ServicioSalud servicioSalud, Ips ips) {
        this.pk = new ServicioIpsPK(servicioSalud.getNombre(), ips.getNit());
        this.servicioSalud = servicioSalud;
        this.ips = ips;
    }

    public ServicioIps()
    {;}

    public ServicioIpsPK getPk() {
        return pk;
    }

    public void setPk(ServicioIpsPK pk) {
        this.pk = pk;
    }

}
