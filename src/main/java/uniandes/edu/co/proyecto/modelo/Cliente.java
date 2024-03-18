package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona {

  @EmbeddedId
  private ClientePK pk;

  public Cliente() {
    ;
  }

  public Cliente(Persona numeroDocumento, UsuarioCliente login) {
    this.pk = new ClientePK(numeroDocumento, login);
  }

  public ClientePK getPk() {
    return pk;
  }

  public void setPk(ClientePK pk) {
    this.pk = pk;
  }
}
