package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>
{
    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    @Query(value = "SELECT * FROM sucursales WHERE id = :id",nativeQuery = true)
    Sucursal darSucursal(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursales WHERE id = :id",nativeQuery = true)
    void eliminarSucursal(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursales SET direccion = :direccion, telefono= :telefono, nombre = :nombr, ciudad_codigo = :codigo_ciudad WHERE id = :id",nativeQuery = true)
    void actualizarSucursal(@Param("id") Integer id, @Param("direccion") String direccion,@Param("telefono") Integer telefono, @Param("nombre") String nombre, @Param("ciudad_codigo") Integer ciudad_codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (direcciones,telefono,nombre) VALUES(:direccion,:telefono,:nombre)",nativeQuery = true)
    void insertarSucursal(@Param("direccion") String direccion,@Param("telefono") Integer telefono, @Param("nombre") String nombre, @Param("ciudad_codigo") Integer ciudad_codigo);
}
