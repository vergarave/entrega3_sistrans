package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vende")
public class Vende 
{
    private Integer reorden;

    private Integer cantidad;

    @EmbeddedId
    private VendePK pk;

    public Vende(Sucursal sucursal_id,Producto producto_id ,Integer reorden, Integer cantidad)
    {
        this.reorden = reorden;
        this.cantidad = cantidad;

        this.pk = new VendePK(sucursal_id,producto_id);
    }

    public Vende()
    {
        ;
    }

    public Integer getReorden() {
        return reorden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public VendePK getPk() {
        return pk;
    }

    public void setReorden(Integer reorden) {
        this.reorden = reorden;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPk(VendePK pk) {
        this.pk = pk;
    }
}