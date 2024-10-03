package uniandes.edu.co.proyecto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "productosucursal")
public class ProductoSucursal {

    @EmbeddedId
    private ProductoSucursalPK id;

    @Column(name = "cantidadminima", nullable = false)
    private Integer cantidadMinima;
}

