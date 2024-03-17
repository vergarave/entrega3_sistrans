package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class TieneCuentaEmpleado {
    @EmbeddedId
    private TieneCuentaEmpleadoPK pk;

    public TieneCuentaEmpleado(){;}

    public TieneCuentaEmpleado(Persona numeroDocumento, UsuarioEmpleado login) {
      this.pk = new TieneCuentaEmpleadoPK(numeroDocumento, login);
    }

    public TieneCuentaEmpleadoPK getPk() {
      return pk;
    }

    public void setPk(TieneCuentaEmpleadoPK pk) {
      this.pk = pk;
    }

}
