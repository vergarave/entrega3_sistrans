package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_clientes")
public class UsuarioCliente {
    @Id
    private String login;
    private String passwordCliente;
    
    public UsuarioCliente(String login, String passwordCliente) {
        this.login = login;
        this.passwordCliente = passwordCliente;
    }

    public String getLogin() {
        return login;
    }
    public String getPasswordCliente() {
        return passwordCliente;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    
}
