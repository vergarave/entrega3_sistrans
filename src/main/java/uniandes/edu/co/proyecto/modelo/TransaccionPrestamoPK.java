package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransaccionPrestamoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    private OperacionPrestamo id_operacion;

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo id_prestamo;

    public TransaccionPrestamoPK() {
        super();
    }

    public TransaccionPrestamoPK(OperacionPrestamo id_operacion, Prestamo id_prestamo) {
        super();
        this.id_operacion = id_operacion;
        this.id_prestamo = id_prestamo;
    }

    public OperacionPrestamo getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(OperacionPrestamo id_operacion) {
        this.id_operacion = id_operacion;
    }

    public Prestamo getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Prestamo id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    

}