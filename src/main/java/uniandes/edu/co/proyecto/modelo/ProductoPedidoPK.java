package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Clase que mapea la llave primaria de la tabla ProductoPedido en la base de datos
@Embeddable
public class ProductoPedidoPK implements Serializable {

    //Relacion con la tabla Producto
    @ManyToOne
    @JoinColumn(name="identificador_producto", referencedColumnName="identificador")
    private Producto identificadorProducto;

    //Relacion con la tabla OrdenDeCompra
    @ManyToOne
    @JoinColumn(name="numero_orden_de_compra", referencedColumnName="numero")
    private OrdenDeCompra numeroOrdenDeCompra;

    public ProductoPedidoPK(Producto identificadorProducto, OrdenDeCompra numeroOrdenDeCompra){
        super();
        this.identificadorProducto = identificadorProducto;
        this.numeroOrdenDeCompra = numeroOrdenDeCompra;
    }

    public ProductoPedidoPK() {
    }

    public Producto getIdentificadorProducto() {
        return identificadorProducto;
    }

    public OrdenDeCompra getNumeroOrdenDeCompra() {
        return numeroOrdenDeCompra;
    }

    public void setIdentificadorProducto(Producto identificadorProducto) {
        this.identificadorProducto = identificadorProducto;
    }

    public void setNumeroOrdenDeCompra(OrdenDeCompra numeroOrdenDeCompra) {
        this.numeroOrdenDeCompra = numeroOrdenDeCompra;
    }


    

}
