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
  private String password_cliente;

  @OneToOne
  @JoinColumn(name = "id_cliente", referencedColumnName = "id")
  private Cliente id_cliente;

  public UsuarioCliente(String login, String password_cliente, Cliente id_cliente) {
    this.login = login;
    this.password_cliente = password_cliente;
    this.id_cliente = id_cliente;
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

  public String getPassword_cliente() {
    return password_cliente;
  }

  public void setPassword_cliente(String password_cliente) {
    this.password_cliente = password_cliente;
  }

  public Cliente getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(Cliente id_cliente) {
    this.id_cliente = id_cliente;
  }

  

}