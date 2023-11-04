package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")

public class cuentas {
    
    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idcuenta;

    private Integer netocuenta;
    //FK
    @ManyToOne
    @JoinColumn(name="alojamientos", referencedColumnName = "idalojamiento")
    private alojamientos alojamiento;


    // Constructor
    public cuentas(Integer netocuenta, alojamientos alojamiento)
    {
        this.netocuenta = netocuenta;
        this.alojamiento = alojamiento;
    }


    public cuentas(){;}


    // Getters
    public Integer getNetocuenta() {
        return netocuenta;
    }

    public alojamientos getAlojamiento() {
        return alojamiento;
    }


    // Setters
    public void setNetocuenta(Integer netocuenta) {
        this.netocuenta = netocuenta;
    }

    public void setAlojamiento(alojamientos alojamiento) {
        this.alojamiento = alojamiento;
    }

}
