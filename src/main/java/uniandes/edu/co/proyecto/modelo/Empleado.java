package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado extends Persona {
  @EmbeddedId
  private EmpleadoPK pk;

  public Empleado() {
    ;
  }

  public Empleado(Persona numeroDocumento, UsuarioEmpleado login) {
    this.pk = new EmpleadoPK(numeroDocumento, login);
  }

  public EmpleadoPK getPk() {
    return pk;
  }

  public void setPk(EmpleadoPK pk) {
    this.pk = pk;
  }

}
