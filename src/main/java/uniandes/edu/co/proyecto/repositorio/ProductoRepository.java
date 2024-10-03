package uniandes.edu.co.proyecto.repositorio;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer>{

    //RF6.1 : Crear un producto
    /**
     * @param nombre
     * @param fecha_expiracion
     * @param codigo_barras
     * @param volumen
     * @param peso
     * @param id_tipo_categoria
     */
    @Modifying
    @Transactional
    @Query(value = "insert into productos (id, nombre, fecha_expiracion, codigo_barras, volumen, peso, id_tipo_categoria) values (ids_producto.nextval, :nombre, :fecha_expiracion, :codigo_barras, :volumen, :peso, :id_tipo_categoria)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("fecha_expiracion") Date fecha_expiracion, @Param("codigo_barras") Integer codigo_barras,@Param("volumen") Float volumen, @Param("peso") Float peso, @Param("id_tipo_categoria") Integer id_tipo_categoria);

    // RF6.2 : Leer un producto por id o nombre
    /**
     * @param id
     * @param nombre
     * @return
     */
    @Query(value = "SELECT * FROM productos b WHERE id = :id or b.nombre = :nombre", nativeQuery=true)
    Collection<Producto> darproductoPorIdONombre(@Param("id") Integer id ,@Param("nombre") String nombre);

    // RF6.3 : Actualizar un producto
    /**
     * @param id
     * @param nombre
     * @param fecha_expiracion
     * @param codigo_barras
     * @param volumen
     * @param peso
     * @param id_tipo_categoria
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, fecha_expiracion = :fecha_expiracion, codigo_barras = :codigo_barras, volumen = :volumen, peso = :peso, id_tipo_categoria = :id_tipo_categoria WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("fecha_expiracion") Date fecha_expiracion, @Param("codigo_barras") Integer codigo_barras,@Param("volumen") Float volumen, @Param("peso") Float peso, @Param("id_tipo_categoria") Integer id_tipo_categoria);

}
