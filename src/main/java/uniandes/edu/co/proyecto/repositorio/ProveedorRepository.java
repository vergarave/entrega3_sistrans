package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

//Repositorio de la entidad Proveedor que se encarga de realizar las consultas a la base de datos
public interface ProveedorRepository extends JpaRepository<Proveedor, String>{

    boolean existsByNit(String nit);

    //Consulta CRUD de darProveedores
    @Query(value = "SELECT * FROM proveedor", nativeQuery=true)
    Collection<Proveedor> darProveedores();

    //Consulta CRUD de darProveedor
    @Query(value = "SELECT * FROM proveedor WHERE nit= :nit", nativeQuery=true)
    Proveedor darProveedor(@Param("nit") String nit);

    //Consulta CRUD de insertarProveedor
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "INSERT INTO proveedor(nit, nombre, direccion, nombre_persona_contacto, telefono_persona_contacto) VALUES(:nit, :nombre, :direccion, :nombre_persona_contacto, :telefono_persona_contacto)", nativeQuery = true)
    void insertarProveedor(@Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_persona_contacto") String nombrePersonaContacto, @Param("telefono_persona_contacto") String telefonoPersonaContacto);

    //Consulta CRUD de actualizarProveedor
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "UPDATE proveedor SET nombre=:nombre, direccion=:direccion, nombre_persona_contacto=:nombre_persona_contacto, telefono_persona_contacto=:telefono_persona_contacto WHERE nit=:nit", nativeQuery= true)
    void actualizarProveedor(@Param("nit") String nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombre_persona_contacto") String nombrePersonaContacto, @Param("telefono_persona_contacto") String telefonoPersonaContacto);

}
