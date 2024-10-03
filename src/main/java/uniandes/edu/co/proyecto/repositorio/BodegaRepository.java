package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega,Integer>{

    /**
     * RF#.1 : Crea una bodega dada su informacion
     * SQL   : Inserta un nuevo registro en la tabla 'bodegas'
     *              con un ID generado automáticamente y valores
     *              específicos para nombre, tamaño y sucursal
     * @param nombre nombre de la bodega
     * @param tamanio tamanio de la bodega en mts cuadrados
     * @param id_sucursal identificador de la sucursal asocidada
     */
    @Modifying
    @Transactional
    @Query(value = "insert into bodegas (id,nombre,tamanio,id_sucursal) values (ids_bodega.nextval, :nombre, :tamanio, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") String tamanio, @Param("id_sucursal") Integer id_sucursal);

    /**
     * RF3.2 : Borrar una bodega
     * SQL   : Elimina un registro de la tabla 'bodegas' cuyo ID 
     *              coincide con el valor proporcionado
     * @param id identificador de la bodega que se eliminar
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") Integer id);

    /**
     * Obtener la ultima bodega creada
     * @return collection con un unico elemento que sera el ultimo id creado
     */
    @Query(value = "SELECT * FROM bodegas WHERE id = (SELECT MAX(id) FROM bodegas)", nativeQuery = true)
    Collection<Bodega> getLast();

}
