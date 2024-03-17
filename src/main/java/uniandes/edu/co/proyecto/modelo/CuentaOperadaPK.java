package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class CuentaOperadaPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_operacion", referencedColumnName = "id")
    private OperacionCuenta idOperacion;


    @OneToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "numero_cuenta")
    private Cuenta idCuenta;
    
    public CuentaOperadaPK()
    {
        super();
    }

    public CuentaOperadaPK(OperacionCuenta idOperacion, Cuenta idCuenta) {
        this.idOperacion = idOperacion;
        this.idCuenta = idCuenta;
    }

    public OperacionCuenta getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(OperacionCuenta idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    

}
