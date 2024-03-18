package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pertenecen")
public class Pertenece {
    @EmbeddedId
    private PertenecePK pk;

    public Pertenece() {
        ;
    }

    public Pertenece(Oficina id_Oficina, PuntoAtencion id_PuntoAtencion) {
        this.pk = new PertenecePK(id_Oficina, id_PuntoAtencion);
    }

    public PertenecePK getPk() {
        return pk;
    }

    public void setPk(PertenecePK pk) {
        this.pk = pk;
    }

}
