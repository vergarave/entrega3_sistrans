package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TransaccionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_OperacionCuenta", referencedColumnName = "id")
    private OperacionCuenta id_OperacionCuenta;

    @ManyToOne
    @JoinColumn(name = "id_Cuenta", referencedColumnName = "id")
    private Cuenta id_Cuenta;

    public TransaccionPK() {
        super();
    }

    public TransaccionPK(OperacionCuenta id_OperacionCuenta, Cuenta id_Cuenta) {
        this.id_OperacionCuenta = id_OperacionCuenta;
        this.id_Cuenta = id_Cuenta;
    }

    public OperacionCuenta getId_OperacionCuenta() {
        return id_OperacionCuenta;
    }

    public void setId_OperacionCuenta(OperacionCuenta id_OperacionCuenta) {
        this.id_OperacionCuenta = id_OperacionCuenta;
    }

    public Cuenta getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(Cuenta id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

}
