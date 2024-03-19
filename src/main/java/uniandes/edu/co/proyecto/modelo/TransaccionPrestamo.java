package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "transaccion_prestamos")
public class TransaccionPrestamo {
    @EmbeddedId
    private TransaccionPrestamoPK pk;

    public TransaccionPrestamo() {
        ;
    }

    public TransaccionPrestamo(OperacionPrestamo idOperacion, Prestamo idPrestamo) {
        this.pk = new TransaccionPrestamoPK(idOperacion, idPrestamo);
    }

    public TransaccionPrestamo getPk() {
        return pk;
    }

    public void setPk(TransaccionPrestamo pk) {
        this.pk = pk;
    }

}