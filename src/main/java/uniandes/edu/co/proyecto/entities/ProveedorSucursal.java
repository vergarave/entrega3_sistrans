package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedorsucursal")
public class ProveedorSucursal {

    @EmbeddedId
    private ProveedorSucursalPK id;
}
