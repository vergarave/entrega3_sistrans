package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Clase que mapea la tabla ProductoProveedor en la base de datos
@Entity
@Table(name="producto_proveedor")
public class ProductoProveedor {
    
    //Llave primaria compuesta
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
