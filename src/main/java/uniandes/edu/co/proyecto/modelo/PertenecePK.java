package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PertenecePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_oficina", referencedColumnName = "id")
    private Oficina idOficina;


    @ManyToOne
    @JoinColumn(name = "id_punto_atencion", referencedColumnName = "id")
    private PuntoAtencion idPuntoAtencion;

    public PertenecePK()
    {
        super();
    }

    public PertenecePK(Oficina idOficina, PuntoAtencion idPuntoAtencion) {
        this.idOficina = idOficina;
        this.idPuntoAtencion = idPuntoAtencion;
    }

    public Oficina getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Oficina idOficina) {
        this.idOficina = idOficina;
    }

    public PuntoAtencion getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(PuntoAtencion idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }

    

}
