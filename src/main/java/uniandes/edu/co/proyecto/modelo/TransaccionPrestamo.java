package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacciones_prestamos")
public class TransaccionPrestamo {
    
    @EmbeddedId
    private TransaccionPrestamoPK pk;

    public TransaccionPrestamo() {
        ;
    }

    public TransaccionPrestamo(OperacionPrestamo idOperacion, Prestamo idPrestamo) {
        this.pk = new TransaccionPrestamoPK(idOperacion, idPrestamo);
    }

    public TransaccionPrestamoPK getPk() {
        return pk;
    }

    public void setPk(TransaccionPrestamoPK pk) {
        this.pk = pk;
    }

}