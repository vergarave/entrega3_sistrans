package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RealizadaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_operacion_cuenta", referencedColumnName = "id")
    private OperacionCuenta idOperacionCuenta;


    @ManyToOne
    @JoinColumn(name = "id_punto_atencion", referencedColumnName = "id")
    private PuntoAtencion idPuntoAtencion;

    public RealizadaPK()
    {
        super();
    }

    public RealizadaPK(OperacionCuenta idOperacionCuenta, PuntoAtencion idPuntoAtencion) {
        this.idOperacionCuenta = idOperacionCuenta;
        this.idPuntoAtencion = idPuntoAtencion;
    }

    public OperacionCuenta getIdOperacionCuenta() {
        return idOperacionCuenta;
    }

    public void setIdOperacionCuenta(OperacionCuenta idOperacionCuenta) {
        this.idOperacionCuenta = idOperacionCuenta;
    }

    public PuntoAtencion getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(PuntoAtencion idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }

    
}
