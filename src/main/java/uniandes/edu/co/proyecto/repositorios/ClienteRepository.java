package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  @Query(value = "SELECT * FROM clientes", nativeQuery = true)
  Collection<Cliente> darClientes();

  @Query(value = "SELECT * FROM clientes WHERE id=:id", nativeQuery = true)
  Cliente darCliente(@Param("id") int id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO clientes (id, numero_documento, tipo,tipoDocumento, nombre,nacionalidad, direccion_fisica, direccion_electronica,telefono,codigo_postal,ciudad,departamento) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  void insertarCliente(@Param("numero_documento") Integer numero_documento,
      @Param("tipo") String tipo,
      @Param("tipoDocumento") String tipoDocumento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccionFisica,
      @Param("direccion_electronica") String direccionElectronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigoPostal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento);

  @Modifying
  @Transactional
  @Query(value = "UPDATE clientes SET numero_documento=: numero_documento, tipo = :tipo, tipoDocumento = :tipoDocumento,nombre = :nombre, nacionalidad =: nacionalidad, direccionFisica =: direccionFisica,direccionElectronica =: direccionElectronica ,codigoPostal=: codigoPostal, ciudad=:ciudad, departamento:=departamento  WHERE numero_documento = :numero_documento", nativeQuery = true)
  void actualizarCliente(@Param("id") Integer id,
      @Param("numero_documento") Integer numero_documento,
      @Param("tipo") String tipo,
      @Param("tipoDocumento") String tipoDocumento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccionFisica,
      @Param("direccion_electronica") String direccionElectronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigoPostal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM clientes WHERE id=:id", nativeQuery = true)
  void eliminarCliente(@Param("id") int id);

}
