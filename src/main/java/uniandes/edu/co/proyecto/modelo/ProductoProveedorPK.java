package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoProveedorPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="identificador_producto", referencedColumnName = "identificador")
    private Producto identificadorProducto;

    @ManyToOne
    @JoinColumn(name="nit_proveedor", referencedColumnName = "nit")
    private Proveedor nitProveedor;

    public ProductoProveedorPK(Producto identificadorProducto, Proveedor nitProveedor){
        super();
        this.identificadorProducto = identificadorProducto;
        this.nitProveedor = nitProveedor;
    }

    public Producto getIdentificadorProducto() {
        return identificadorProducto;
    }

    public Proveedor getNitProveedor() {
        return nitProveedor;
    }

    public void setIdentificadorProducto(Producto identificadorProducto) {
        this.identificadorProducto = identificadorProducto;
    }

    public void setNitProveedor(Proveedor nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    
}