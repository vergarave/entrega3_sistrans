package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "documento_ingreso")
public class DocumentoIngreso {

    // Esto ayuda a que, como recién añadimos la secuencia, no se pierda nada
    // Sin esto, Hibernate podría llegar a perder cuál secuencia usar, entonces como buena práctica es mejor ponerlo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_ingreso_seq")
    @SequenceGenerator(name = "documento_ingreso_seq", sequenceName = "SECUENCIA_DOCUMENTO_INGRESO", allocationSize = 1)
    private Integer id;

    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_bodega", referencedColumnName = "id")
    private Bodega bodega;

    @OneToOne
    @JoinColumn(name = "numero_orden_de_compra", referencedColumnName = "numero")
    private OrdenDeCompra ordenCompra;

    public DocumentoIngreso() {}

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public OrdenDeCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenDeCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
}
