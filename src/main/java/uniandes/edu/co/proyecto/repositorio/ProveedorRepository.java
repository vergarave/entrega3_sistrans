package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, String>{

@Query(value = "SELECT * FROM proveedor", nativeQuery=true)
Collection<Proveedor> darProveedores();

@Query(value = "SELECT * FROM sucursal WHERE nit= :nit", nativeQuery=true)
    Proveedor darProveedor(@Param("nit") String nit);

@Modifying
@Transactional
@Query(value = "INSERT INTO proveedor(nit, nombre, direccion, nombre_persona_contacto, telefono_persona_contacto) VALUES(:nit, :nombre, :direccion, :nombre_persona_contacto, :telefono_persona_contacto)", nativeQuery = true)
void insertarProveedor(@Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_persona_contacto") String nombrePersonaContacto, @Param("telefono_persona_contacto") String telefonoPersonaContacto);

@Modifying
@Transactional
@Query(value = "UPDATE proveedor SET nombre=:nombre, direccion=:direccion, nombre_persona_contacto=:nombre_persona_contacto, telefono_persona_contacto=:telefono_persona_contacto WHERE nit=:nit", nativeQuery= true)
void actualizarProveedor(@Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_persona_contacto") String nombrePersonaContacto, @Param("telefono_persona_contacto") String telefonoPersonaContacto);

}
