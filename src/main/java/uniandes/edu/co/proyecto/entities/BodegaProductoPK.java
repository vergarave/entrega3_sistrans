package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Embeddable
public class BodegaProductoPK {

    @ManyToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id", nullable = false)
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false)
    private Producto producto;
}

