package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta extends Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dinero;
    
    public Cuenta()
    {;}

    public Cuenta(Integer id, Cliente cliente, String estado,Integer dinero) {
        super(id, cliente, estado);
        this.dinero = dinero;}

    
    public Integer getDinero() {
        return dinero;
    }
    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    
}
