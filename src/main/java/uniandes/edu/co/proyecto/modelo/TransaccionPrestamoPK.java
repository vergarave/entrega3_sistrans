package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransaccionPrestamoPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    private OperacionPrestamo idOperacion;

    @OneToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo idPrestamo;

    public TransaccionPrestamoPK() {
        super();
    }

    public TransaccionPrestamoPK(OperacionPrestamo idOperacion, Prestamo idPrestamo) {
        this.idOperacion = idOperacion;
        this.idPrestamo = idPrestamo;
    }

    public OperacionPrestamo getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(OperacionPrestamo idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

}