package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")

public class productos {
    
    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idproducto;

    private String nombre;
    private Integer precio;
    //FK
    @ManyToOne
    @JoinColumn(name="bares", referencedColumnName = "idservicio")
    private bares bar;
    @ManyToOne
    @JoinColumn(name="restaurantes", referencedColumnName = "idservicio")
    private restaurantes restaurante;
    @ManyToOne
    @JoinColumn(name="tiendas", referencedColumnName = "idservicio")
    private tiendas tienda;


    // Constructor
    public productos(String nombre, Integer precio, Integer idproducto, bares bar, restaurantes restaurante, tiendas tienda)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.idproducto = idproducto;
        this.bar = bar;
        this.restaurante = restaurante;
        this.tienda = tienda;
    }


    public productos(){;}


    // Getters
    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public bares getBar() {
        return bar;
    }

    public restaurantes getRestaurante() {
        return restaurante;
    }

    public tiendas getTienda() {
        return tienda;
    }


    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public void setBar(bares bar) {
        this.bar = bar;
    }

    public void setRestaurante(restaurantes restaurante) {
        this.restaurante = restaurante;
    }

    public void setTienda(tiendas tienda) {
        this.tienda = tienda;
    }
    
}
