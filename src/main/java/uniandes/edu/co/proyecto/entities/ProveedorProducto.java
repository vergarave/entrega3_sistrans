package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedorproducto")
public class ProveedorProducto {

    @EmbeddedId
    private ProveedorProductoPK id;
}
