package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_clientes")
public class UsuarioCliente {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String login;
  private String password_clientes;

  @OneToOne
  @JoinColumn(name = "id", referencedColumnName = "id")
  private Cliente idCliente;

  public UsuarioCliente(String login, String password_clientes, Cliente idCliente) {
    this.login = login;
    this.password_clientes = password_clientes;
    this.idCliente = idCliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword_clientes() {
    return password_clientes;
  }

  public void setPassword_clientes(String password_clientes) {
    this.password_clientes = password_clientes;
  }

  public Cliente getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Cliente idCliente) {
    this.idCliente = idCliente;
  }

}