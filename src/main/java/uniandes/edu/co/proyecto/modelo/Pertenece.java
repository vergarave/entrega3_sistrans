package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pertenecen")
public class Pertenece {
    @EmbeddedId
    private PertenecePK pk;

    public Pertenece(){;}


    
    public Pertenece(PertenecePK pk) {
        this.pk = pk;
    }

    public PertenecePK getPk() {
        return pk;
    }

    public void setPk(PertenecePK pk) {
        this.pk = pk;
    }

}
