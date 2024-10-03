package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Embeddable
public class ProductoSucursalPK {

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", nullable = false)
    private Producto producto;
}
