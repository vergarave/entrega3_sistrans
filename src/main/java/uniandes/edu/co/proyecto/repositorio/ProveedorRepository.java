package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>{

    // RF4.1 : Crear un proveedor
    /**
     * @param nombre
     * @param telefono
     * @param direccion
     */
    @Modifying
    @Transactional
    @Query(value = "insert into proveedores (id,nombre,telefono,direccion) values (ids_proveedor.nextval, :nombre, :telefono, :direccion)", nativeQuery = true)
    void insertarProveedor(@Param("nombre") String nombre, @Param("telefono") String telefono,@Param("direccion") String direccion);

    // RF4.2 : Actualizar un proveedor
    /**
     * @param id
     * @param nombre
     * @param telefono
     * @param direccion
     */
    @Modifying
    @Transactional
    @Query(value = "update proveedores set nombre = :nombre, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarProveedor(@Param("id") Integer id, @Param("nombre") String nombre, @Param("telefono") String telefono, @Param("direccion") String direccion);

}
