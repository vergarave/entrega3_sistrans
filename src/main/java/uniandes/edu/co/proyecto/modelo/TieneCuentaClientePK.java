package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class TieneCuentaClientePK implements Serializable {

    @OneToOne
    @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento")
    private Persona numeroDocumento;


    @OneToOne
    @JoinColumn(name = "login", referencedColumnName = "login")
    private UsuarioCliente login;

    public TieneCuentaClientePK()
    {
        super();
    }

    
    public TieneCuentaClientePK(Persona numeroDocumento, UsuarioCliente login)
    {
        super();
        this.numeroDocumento = numeroDocumento;
        this.login = login;
    }


    public Persona getNumeroDocumento() {
        return numeroDocumento;
    }


    public UsuarioCliente getLogin() {
        return login;
    }


    public void setNumeroDocumento(Persona numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    public void setLogin(UsuarioCliente login) {
        this.login = login;
    }
}
