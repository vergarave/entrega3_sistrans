package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,String>  {

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();
    
    @Query(value = "SELECT * FROM cuentas WHERE numero_cuenta= :numeroCuenta", nativeQuery = true)
    Cuenta darCuenta(@Param("numero_cuenta") int numeroCuenta);

    @Query(value = "INSERT INTO operaciones_cuentas (id,tipo_operacion, fecha,cuenta_salida, monto_operacion , cliente, punto_atencion,cuenta_llegada) VALUEs(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionCuenta insertarOperacionCuenta0(@Param("id") Integer id, @Param("tipo_operacion") String tipoOperacion, 
                                            @Param("fecha") Date fecha,@Param("cuenta_salida")  String cuentaSalida, @Param("monto_operacion") String montoOperacion,
                                            @Param("cliente") Date cliente, @Param("punto_atencion") String puntoAtencion, @Param("cuenta_llegada") String cuentaLlegada);
    
}
