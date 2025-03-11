package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosips")
public class ServicioIps {
    
    @EmbeddedId
    private ServicioIpsPK pk;
    
    public ServicioIps(ServicioSalud nombreServicio, Ips nitIps){
        this.pk = new ServicioIpsPK(nombreServicio, nitIps);
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
