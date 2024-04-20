package uniandes.edu.co.proyecto.repositorios;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

      public interface RespuestaExtracto {

        double getSALDO();
        String getTIPO_OPERACION();
        Timestamp getFECHA();
      }





  @Query(value = "SELECT * FROM clientes", nativeQuery = true)
  Collection<Cliente> darClientes();

  @Query(value = "SELECT * FROM clientes WHERE id=:id", nativeQuery = true)
  Cliente darCliente(@Param("id") long  id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO clientes (id, numero_documento, tipo,tipo_documento, nombre,nacionalidad, direccion_fisica, direccion_electronica,telefono,codigo_postal,ciudad,departamento) VALUES(proyecto_sequence.nextval, :numero_documento, :tipo, :tipo_documento, :nombre, :nacionalidad, :direccion_fisica, :direccion_electronica, :telefono, :codigo_postal, :ciudad, :departamento) ", nativeQuery = true)
  void insertarCliente(@Param("numero_documento") String numero_documento,
      @Param("tipo") String tipo,
      @Param("tipo_documento") String tipo_documento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccion_fisica,
      @Param("direccion_electronica") String direccion_electronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigo_postal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento);

  @Modifying
  @Transactional
  @Query(value = "UPDATE clientes SET numero_documento=:numero_documento, tipo = :tipo, tipo_documento = :tipo_documento,nombre = :nombre, nacionalidad = :nacionalidad, direccion_fisica = :direccion_fisica, direccion_electronica = :direccion_electronica , telefono = :telefono, codigo_postal = :codigo_postal, ciudad = :ciudad, departamento= :departamento  WHERE id = :id", nativeQuery = true)
  void actualizarCliente(@Param("id") long  id,
      @Param("numero_documento") String numero_documento,
      @Param("tipo") String tipo,
      @Param("tipo_documento") String tipo_documento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccion_fisica,
      @Param("direccion_electronica") String direccion_electronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigo_postal ,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM clientes WHERE id= :id", nativeQuery = true)
  void eliminarCliente(@Param("id") long  id);



  @Query(value = "SELECT CUENTAS.saldo as SALDO, operaciones_cuentas.tipo_operacion AS TIPO_OPERACION,operaciones_cuentas.fecha AS FECHA \r\n" + //
          "FROM CUENTAS \r\n" + //
          "INNER JOIN OPERACIONES_CUENTAS ON operaciones_cuentas.cuenta_salida = cuentas.numero_cuenta \r\n" + //
          "WHERE EXTRACT(MONTH FROM operaciones_cuentas.fecha) = :numMes AND EXTRACT(YEAR FROM operaciones_cuentas.fecha) = :anio AND cuentas.numero_cuenta = :numCuenta\r\n" + //
          "ORDER BY operaciones_cuentas.fecha ASC", nativeQuery = true)
  Collection<RespuestaExtracto>  infoExtracto(@Param("numMes") Integer  numMes,@Param("numCuenta") Integer  numCuenta, @Param("anio") Integer  anio);

}
