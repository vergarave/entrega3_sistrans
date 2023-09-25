package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "CARTA")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // This will act as a primary key

    @ManyToOne
    @JoinColumn(name = "bar_id")
    private Bar bar;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    private String producto;

    public Carta(Bar bar, Restaurante restaurante, String producto) {
        this.bar = bar;
        this.restaurante = restaurante;
        this.producto = producto;
    }

    public Carta() {;}

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}

