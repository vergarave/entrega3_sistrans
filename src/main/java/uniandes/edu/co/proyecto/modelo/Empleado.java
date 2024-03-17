package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado extends Persona {

  private String login;
  private String password;

  public Empleado() {
    ;
  }

  public Empleado(String login, String password) {
    this.login = login;
    this.password = password;
  }

}
