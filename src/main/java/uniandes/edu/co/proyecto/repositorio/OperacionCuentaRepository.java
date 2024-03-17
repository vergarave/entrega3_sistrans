package uniandes.edu.co.proyecto.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.OperacionCuenta;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta,Integer> {
    
    @Query(value = "SELECT * FROM operaciones_cuentas", nativeQuery = true)
    Collection<OperacionCuenta> darOperacionesCuentas();
    
    @Query(value = "SELECT * FROM operaciones_cuentas WHERE id= :id", nativeQuery = true)
    OperacionCuenta darOperacionCuenta(@Param("id") int id);

    @Query(value = "INSERT INTO operaciones_cuentas (id,tipo_operacion, fecha,cuenta_salida, monto_operacion , cliente, punto_atencion,cuenta_llegada) VALUEs(proyecto_sequence.nextval) ", nativeQuery = true)
    OperacionCuenta insertarOperacionCuenta0(@Param("id") Integer id, @Param("tipo_operacion") String tipoOperacion, 
                                            @Param("fecha") Date fecha,@Param("cuenta_salida")  String cuentaSalida, @Param("monto_operacion") String montoOperacion,
                                            @Param("cliente") Date cliente, @Param("punto_atencion") String puntoAtencion, @Param("cuenta_llegada") String cuentaLlegada);
    
    


    
}
