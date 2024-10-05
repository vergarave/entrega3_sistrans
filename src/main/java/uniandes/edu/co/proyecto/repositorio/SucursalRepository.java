package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{

    /**
     * RF2 : Crear una sucursal
     * SQL : -- Inserta una nueva sucursal en la tabla 'sucursales' con un ID generado
     *              automáticamente y valores específicos para nombre, tamaño, teléfono,
     *              dirección y ciudad.
     * @param nombre nombre de la sucursal
     * @param tamanio tamanio de la sucursal en mts cuadrados
     * @param telefono numero de telefono
     * @param direccion ubicacion de la sucursal
     * @param id_ciudad identificador de la ciudad donde se encuentra la sucursal
     */
    @Modifying
    @Transactional
    @Query(value = "insert into sucursales (id,nombre,tamanio,telefono,direccion,id_ciudad) values (ids_sucursal.nextval, :nombre, :tamanio, :telefono, :direccion, :id_ciudad)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") String tamanio, @Param("telefono") String telefono,@Param("direccion") String direccion, @Param("id_ciudad") Integer id_ciudad);

    /**
     * Obtener la ultima sucursal creada
     * @return collection con un unico elemento que sera el ultimo id creado
     */
    @Query(value = "SELECT * FROM sucursales WHERE id = (SELECT MAX(id) FROM sucursales)", nativeQuery = true)
    Collection<Sucursal> getLast();

    /**
     * RFC4 : Mostrar las sucursales en las que hay un producto dado su id o nombre
     * @param id identificador del producto a buscar
     * @param nombre nombre del producto a buscar
     * @return collection con las bodegas encontradas
     */
    @Query(value = "select su.*, pr.id, pr.nombre from sucursales su join bodegas bo on su.id = bo.id_sucursal join contiene co on bo.id = co.id_bodega join productos pr on co.id_producto = pr.id where pr.id = :id or pr.nombre = :nombre", nativeQuery = true)
    Collection<Object[]> darSucursalesConProducto(@Param("id") Integer id, @Param("nombre") String nombre);

}
