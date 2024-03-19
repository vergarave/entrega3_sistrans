package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OperacionPrestamoRealizadaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_operacion_prestamo", referencedColumnName = "id_operacion_prestamo")
    private OperacionPrestamo idOperacionPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_punto_atencion", referencedColumnName = "id_punto_atencion")
    private PuntoAtencion idPuntoAtencion;

    public OperacionPrestamoRealizadaPK() {
        super();
    }

    public OperacionPrestamoRealizadaPK(OperacionPrestamo idOperacionPrestamo, PuntoAtencion idPuntoAtencion) {
        this.idOperacionPrestamo = idOperacionPrestamo;
        this.idPuntoAtencion = idPuntoAtencion;
    }

    public OperacionPrestamo getIdOperacionPrestamo() {
        return idOperacionPrestamo;
    }

    public void setIdOperacionPrestamo(OperacionPrestamo idOperacionPrestamo) {
        this.idOperacionPrestamo = idOperacionPrestamo;
    }

    public PuntoAtencion getIdPuntoAtencion() {
        return idPuntoAtencion;
    }

    public void setIdPuntoAtencion(PuntoAtencion idPuntoAtencion) {
        this.idPuntoAtencion = idPuntoAtencion;
    }

}
