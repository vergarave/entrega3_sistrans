package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;

import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{

    @Query(value = "SELECT * FROM usuarios_clientes", nativeQuery = true)
    Collection<UsuarioCliente> darUsuariosClientes();

    @Query(value = "SELECT * FROM usuarios_clientes WHERE id = :id", nativeQuery = true)
    UsuarioCliente darUsuarioCliente(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios_clientes WHERE id = :id", nativeQuery = true)
    void eliminarUsuarioCliente(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios_clientes (id, login, password_cliente, id_cliente)  \r\n" + //
                    "VALUES(proyecto_sequence.nextval, :login, :password_cliente, :id_cliente) ", nativeQuery = true)
    void  insertarUsuarioCliente(@Param("login") String login,
        @Param("password_cliente") String password_cliente,
        @Param("id_cliente") Integer id_cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios_clientes SET login= :login, password_cliente= :password_cliente, id_cliente= :id_cliente WHERE id = :id", nativeQuery = true)
    void  actualizarUsuarioCliente(@Param("id") long id,
        @Param("login") String login,
        @Param("password_cliente") String password_cliente,
        @Param("id_cliente") Integer id_cliente);

    @Query(value = "SELECT clientes.id \r\n" + //
        "FROM usuarios_clientes \r\n" + //
        "INNER JOIN clientes on usuarios_clientes.id = clientes.id \r\n" + //
        "WHERE usuarios_clientes.login= :login AND usuarios_clientes.password_cliente= :password_cliente", nativeQuery = true)
    String verificarUsuarioCliente(@Param("login") String login,
                                 @Param("password_cliente") String password_cliente); 

}
