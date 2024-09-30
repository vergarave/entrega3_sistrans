package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Clase que mapea la tabla ProductoPedido en la base de datos
@Entity
@Table(name="producto_pedido")
public class ProductoPedido {
    
    //Llave primaria compuesta
    @EmbeddedId
    private ProductoPedidoPK pk;

    //Atributos de la clase
    private Integer cantidadEnOrden;

    public ProductoPedido(Producto identificadorProducto, OrdenDeCompra numeroOrdenDeCompra, Integer cantidadEnOrden){
        this.pk = new ProductoPedidoPK(identificadorProducto, numeroOrdenDeCompra);
        this.cantidadEnOrden = cantidadEnOrden;
    }

    public ProductoPedido(){
    ;}

    public ProductoPedidoPK getPk() {
        return pk;
    }

    public Integer getCantidadEnOrden() {
        return cantidadEnOrden;
    }

    public void setPk(ProductoPedidoPK pk) {
        this.pk = pk;
    }

    public void setCantidadEnOrden(Integer cantidadEnOrden) {
        this.cantidadEnOrden = cantidadEnOrden;
    }

    

}
