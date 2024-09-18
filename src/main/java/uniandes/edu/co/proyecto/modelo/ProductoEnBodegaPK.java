package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoEnBodegaPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="identificador_producto", referencedColumnName="identificador")
    private Producto idProducto;
    
    @ManyToOne
    @JoinColumn(name="id_bodega", referencedColumnName="id")
    private Bodega idBodega;

    public ProductoEnBodegaPK(Producto idProducto, Bodega idBodega) {
        super();
        this.idProducto = idProducto;
        this.idBodega = idBodega;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    

    

}
