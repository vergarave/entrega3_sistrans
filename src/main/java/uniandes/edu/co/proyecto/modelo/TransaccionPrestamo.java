package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;



@Entity
@Table(name="TransaccionPrestamos")
public class TransaccionPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    private OperacionPrestamo idOperacion;

    @OneToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id")
    private Prestamo idPrestamo;



    public TransaccionPrestamo(int id) {
        this.id = id;

    }
}