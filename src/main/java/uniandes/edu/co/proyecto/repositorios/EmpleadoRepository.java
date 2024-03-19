package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.Collection;

import uniandes.edu.co.proyecto.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
  @Query(value = "SELECT * FROM empleados", nativeQuery = true)
  Collection<Empleado> darEmpleados();

  @Query(value = "SELECT * FROM empleados WHERE id = :id", nativeQuery = true)
  Empleado darEmpleado(@Param("id") Integer id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO empleados (id, numero_documento, tipo,tipo_documento, nombre, nacionalidad, direccion_fisica,direccion_electronica,telefono,codigo_postal,ciudad,departamento,cargo) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  void insertarEmpleado(
      @Param("numero_documento") Integer numero_documento,
      @Param("tipo") String tipo,
      @Param("tipo_documento") String tipo_documento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccion_fisica,
      @Param("direccion_electronica") String direccion_electronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigo_postal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento,
      @Param("cargo") String cargo);

  @Modifying
  @Transactional
  @Query(value = "UPDATE empleados SET numero_documento=: numero_documento, tipo = :tipo, tipoDocumento = :tipoDocumento,nombre = :nombre, nacionalidad =: nacionalidad, direccionFisica =: direccionFisica,direccionElectronica =: direccionElectronica ,codigoPostal=: codigoPostal, ciudad=:ciudad, departamento:=departamento,cargo=: cargo  WHERE numero_documento = :numero_documento", nativeQuery = true)
  void actualizarEmpleado(
      @Param("id") Integer id,
      @Param("numero_documento") Integer numero_documento,
      @Param("tipo") String tipo,
      @Param("tipo_documento") String tipo_documento,
      @Param("nombre") String nombre,
      @Param("nacionalidad") String nacionalidad,
      @Param("direccion_fisica") String direccion_fisica,
      @Param("direccion_electronica") String direccion_electronica,
      @Param("telefono") String telefono,
      @Param("codigo_postal") String codigo_postal,
      @Param("ciudad") String ciudad,
      @Param("departamento") String departamento,
      @Param("cargo") String cargo);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM empleados WHERE id = :id", nativeQuery = true)
  void eliminarEmpleado(@Param("id") Integer id);

}
