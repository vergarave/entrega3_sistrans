package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name = "prestamos")
public abstract class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer interes;
    private Integer cuotas;
    private Integer valorCuenta;
    private Integer monto;
    private String diaCorte;



    public Prestamo()
        {;}

   

    public Prestamo(Integer id, Cliente cliente, String estado, Integer interes, Integer cuotas, Integer valorCuenta, Integer monto, String diaCorte) {
       super(id,cliente, estado);
       this.interes = interes;
       this.cuotas  = cuotas;  
       this.valorCuenta = valorCuenta;
       this.monto   = monto;
       this.diaCorte = diaCorte;}

       public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getValorCuenta() {
        return valorCuenta;
    }

    public void setValorCuenta(Integer valorCuenta) {
        this.valorCuenta = valorCuenta;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getDiaCorte() {
        return diaCorte;
    }

    public void setDiaCorte(String diaCorte) {
        this.diaCorte = diaCorte;
    }

       

        
