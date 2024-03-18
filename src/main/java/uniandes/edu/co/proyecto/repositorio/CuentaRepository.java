package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE numeroCuenta= :numeroCuenta", nativeQuery = true)
    Cuenta darCuenta(@Param("numero_cuenta") int numeroCuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery = true)
    void eliminarBebedor(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (numeroCuenta, estado, saldo, tipo, ultimaTransaccion, fechaCreacion, gerente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionCuenta insertarCuenta(@Param("estado") String estado,
            @Param("saldo") double saldo,
            @Param("tipo") String tipo,
            @Param("ultimaTransaccion") Date ultimaTransaccion,
            @Param("fechaCreacion") Date fechaCreacion,
            @Param("gerente") Empleado gerente);

}
