package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProveePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "producto_nombre", referencedColumnName = "nombre")
    private Producto productoPorNombre;

    @ManyToOne
    @JoinColumn(name = "producto_codigoDeBarras", referencedColumnName = "código_de_barras")
    private Producto productoPorCodigoDeBarras;

    @ManyToOne
    @JoinColumn(name = "proovedor_nit", referencedColumnName = "nit")
    private Proovedor proovedor_nit;

    public ProveePK(Producto productoPorNombre, Producto productoPorCodigoDeBarras, Proovedor proovedor_nit) {
        super();
        this.productoPorNombre = productoPorNombre;
        this.productoPorCodigoDeBarras = productoPorCodigoDeBarras;
        this.proovedor_nit = proovedor_nit;
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

    public Proovedor getProovedor_nit() {
        return proovedor_nit;
    }

    public void setProovedor_nit(Proovedor proovedor_nit) {
        this.proovedor_nit = proovedor_nit;
    }

}