package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class TieneCuentaCliente {
  
    @EmbeddedId
    private TieneCuentaClientePK pk;

    public TieneCuentaCliente(){;}

    public TieneCuentaCliente(Persona numeroDocumento, UsuarioCliente login) {
      this.pk = new TieneCuentaClientePK(numeroDocumento, login);
    }

    public TieneCuentaClientePK getPk() {
      return pk;
    }

    public void setPk(TieneCuentaClientePK pk) {
      this.pk = pk;
    }
}
