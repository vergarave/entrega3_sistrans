package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas_operadas")
public class CuentaOperada {

    @EmbeddedId
    private CuentaOperadaPK pk;

    public CuentaOperada() {;}
    
    public CuentaOperada(CuentaOperadaPK pk) {
        this.pk = pk;
    }

    public CuentaOperadaPK getPk() {
        return pk;
    }

    public void setPk(CuentaOperadaPK pk) {
        this.pk = pk;
    }

    
    
}
