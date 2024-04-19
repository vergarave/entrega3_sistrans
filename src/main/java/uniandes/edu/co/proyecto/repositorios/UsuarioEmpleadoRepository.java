package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;

import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface UsuarioEmpleadoRepository extends JpaRepository<UsuarioEmpleado, Integer> {

    @Query(value = "SELECT * FROM usuarios_empleados", nativeQuery = true)
    Collection<UsuarioEmpleado> darUsuariosEmpleados();

    @Query(value = "SELECT * FROM usuarios_empleados WHERE id = :id", nativeQuery = true)
    UsuarioEmpleado darUsuarioEmpleado(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios_empleados WHERE id = :id", nativeQuery = true)
    void eliminarUsuarioEmpleado(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios_empleados (id, login, password_empleado, id_empleado)  \r\n" + //
                    "VALUES(proyecto_sequence.nextval, :login, :password_empleado, :id_empleado) ", nativeQuery = true)
    void insertarUsuarioEmpleado(@Param("login") String login,
        @Param("password_empleado") String password_empleado,
        @Param("id_empleado") Integer id_empleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios_empleados SET login= :login, password_empleado= :password_empleado, id_empleado= :id_empleado WHERE id = :id", nativeQuery = true)
    void actualizarUsuarioEmpleado(@Param("id") long id,
        @Param("login") String login,
        @Param("password_empleado") String password_empleado,
        @Param("id_empleado") Integer id_empleado);



    @Query(value = "SELECT empleados.cargo \r\n" + //
                    "FROM usuarios_empleados \r\n" + //
                    "INNER JOIN empleados on usuarios_empleados.id_empleado = empleados.id \r\n" + //
                    "WHERE usuarios_empleados.login= :login AND usuarios_empleados.password_empleado= :password_empleado", nativeQuery = true)
    String verificarUsuarioEmpleadoYObtenerCargo(@Param("login") String login,
                                                @Param("password_empleado") String password_empleado);

}
