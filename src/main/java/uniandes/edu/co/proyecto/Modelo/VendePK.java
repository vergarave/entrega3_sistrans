package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class VendePK implements Serializable
{
    @ManyToOne
    @JoinColumn(name="sucursal_id", referencedColumnName = "id")
    private Sucursal sucursal_id;

    @ManyToOne
    @JoinColumn(name = "producto_codigo_de_barras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigo_de_barras;

    public VendePK(Sucursal sucursal_id, Producto producto_codigo_de_barras)
    {
        super();
        this.sucursal_id = sucursal_id;
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }

    public Sucursal getSucursal_id() {
        return sucursal_id;
    }

    public Producto getProducto_id() {
        return producto_codigo_de_barras;
    }

    public void setSucursal_id(Sucursal sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public void setProducto_id(Producto producto_codigo_de_barras) {
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }
}
