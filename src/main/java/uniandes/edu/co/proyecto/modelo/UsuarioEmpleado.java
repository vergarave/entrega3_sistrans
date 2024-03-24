package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_empleados")
public class UsuarioEmpleado {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String login;
  private String password_empleados;
  @OneToOne
  @JoinColumn(name = "id_empleado", referencedColumnName = "id")
  private Empleado id_empleado;

  public UsuarioEmpleado(String login, String password_empleados, Empleado id_empleado) {
    this.login = login;
    this.password_empleados = password_empleados;
    this.id_empleado = id_empleado;
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

  public String getPassword_empleados() {
    return password_empleados;
  }

  public void setPassword_empleados(String password_empleados) {
    this.password_empleados = password_empleados;
  }

  public Empleado getIdEmpleado() {
    return id_empleado;
  }

  public void setIdEmpleado(Empleado id_empleado) {
    this.id_empleado = id_empleado;
  }

}
