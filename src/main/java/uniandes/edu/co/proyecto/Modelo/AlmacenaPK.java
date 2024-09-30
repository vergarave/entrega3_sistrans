package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AlmacenaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "producto_nombre", referencedColumnName = "nombre")
    private Producto productoPorNombre;

    @ManyToOne
    @JoinColumn(name = "producto_codigoDeBarras", referencedColumnName = "código_de_barras")
    private Producto productoPorCodigoDeBarras;

    @ManyToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega id_bodega;

    public AlmacenaPK(Producto productoPorNombre, Producto productoPorCodigoDeBarras, Bodega id_bodega) {
        super();
        this.productoPorNombre = productoPorNombre;
        this.productoPorCodigoDeBarras = productoPorCodigoDeBarras;
        this.id_bodega = id_bodega;
    }

    public Producto getProductoPorNombre() {
        return productoPorNombre;
    }

    public void setProductoPorNombre(Producto productoPorNombre) {
        this.productoPorNombre = productoPorNombre;
    }

    public Producto getProductoPorCodigoDeBarras() {
        return productoPorCodigoDeBarras;
    }

    public void setProductoPorCodigoDeBarras(Producto productoPorCodigoDeBarras) {
        this.productoPorCodigoDeBarras = productoPorCodigoDeBarras;
    }

    public Bodega getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(Bodega id_bodega) {
        this.id_bodega = id_bodega;
    }

}