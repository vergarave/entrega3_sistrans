package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;

public class ProductoProveedor {
    
    @EmbeddedId
    private ProductoProveedorPK pk;

    public ProductoProveedor(Producto identificadorProducto, Proveedor nitProveedor){
        this.pk = new ProductoProveedorPK(identificadorProducto, nitProveedor);
    }

    public ProductoProveedor()
    {;}

    public ProductoProveedorPK getPk() {
        return pk;
    }

    public void setPk(ProductoProveedorPK pk) {
        this.pk = pk;
    }

}
