package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{

    /**
     * RF4.1 : Crear un proveedor
     * SQL   : Inserta un nuevo proveedor en la tabla 'proveedores'
     *              con un ID generado automáticamente y valores
     *                 específicos para nombre, teléfono y dirección.
     * @param nombre
     * @param telefono
     * @param direccion
     */
    @Modifying
    @Transactional
    @Query(value = "insert into proveedores (id,nombre,telefono,direccion) values (ids_proveedor.nextval, :nombre, :telefono, :direccion)", nativeQuery = true)
    void insertarProveedor(@Param("nombre") String nombre, @Param("telefono") String telefono,@Param("direccion") String direccion);

    /**
     * RF4.2 : Actualizar un proveedor
     * SQL : Actualiza el nombre, teléfono y dirección del proveedor en la
     *          tabla 'proveedores' para el registro cuyo ID coincide con el
     *          valor especificado.

     * @param id identificador del proveedor
     * @param nombre nombre actualizado
     * @param telefono telefono actualizado
     * @param direccion direccion actualizada
     */
    @Modifying
    @Transactional
    @Query(value = "update proveedores set nombre = :nombre, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarProveedor(@Param("id") Integer id, @Param("nombre") String nombre, @Param("telefono") String telefono, @Param("direccion") String direccion);

}
