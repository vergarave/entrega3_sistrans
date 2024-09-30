package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RegistroPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "productos_código_de_barras", referencedColumnName = "código_de_barras")
    private Producto productos_código_de_barras;

    @ManyToOne
    @JoinColumn(name = "recepciones_de_productos_id", referencedColumnName = "id")
    private Recepciones recepciones_de_productos_id;

    public RegistroPK(Producto productos_código_de_barras, Recepciones recepciones_de_productos_id) {
        super();
        this.productos_código_de_barras = productos_código_de_barras;
        this.recepciones_de_productos_id = recepciones_de_productos_id;
    }

    public Producto getProductos_código_de_barras() {
        return productos_código_de_barras;
    }

    public void setProductos_código_de_barras(Producto productos_código_de_barras) {
        this.productos_código_de_barras = productos_código_de_barras;
    }

    public Recepciones getRecepciones_de_productos_id() {
        return recepciones_de_productos_id;
    }

    public void setRecepciones_de_productos_id(Recepciones recepciones_de_productos_id) {
        this.recepciones_de_productos_id = recepciones_de_productos_id;
    }

}
