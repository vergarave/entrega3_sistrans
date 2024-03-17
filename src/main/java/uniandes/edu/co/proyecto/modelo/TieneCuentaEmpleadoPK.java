package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class TieneCuentaEmpleadoPK implements Serializable {
    @OneToOne
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    private Persona numeroDocumento;


    @OneToOne
    @JoinColumn(name = "login", referencedColumnName = "login")
    private UsuarioEmpleado login;

    public TieneCuentaEmpleadoPK()
    {
        super();
    }

    
    public TieneCuentaEmpleadoPK(Persona numeroDocumento, UsuarioEmpleado login)
    {
        super();
        this.numeroDocumento = numeroDocumento;
        this.login = login;
    }


    public Persona getNumeroDocumento() {
        return numeroDocumento;
    }


    public UsuarioEmpleado getLogin() {
        return login;
    }


    public void setNumeroDocumento(Persona numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    public void setLogin(UsuarioEmpleado login) {
        this.login = login;
    }

}
