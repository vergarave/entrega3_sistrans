package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "realizada")
public class Realizada {
    
    @EmbeddedId
    private RealizadaPK pk;

    public Realizada(){;}


    
    public Realizada(RealizadaPK pk) {
        this.pk = pk;
    }

    public RealizadaPK getPk() {
        return pk;
    }

    public void setPk(RealizadaPK pk) {
        this.pk = pk;
    }

    

    
}
