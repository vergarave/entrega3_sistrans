package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@Embeddable
public class ProveedorSucursalPK {

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id", nullable = false)
    private Proveedor proveedor;
}

