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

    /**
     * RF6.1 : Crear un producto
     * SQL   : Inserta un nuevo producto en la tabla 'productos' con un ID
     *              generado automáticamente y valores específicos para nombre,
     *              expiración, código de barras, volumen, peso y categoría.
     * @param nombre nombre del producto
     * @param fecha_expiracion fecha en la que expira en formato YYYY-MM-DD, puede ser null
     * @param codigo_barras numero entero que representa el código de barras
     * @param volumen vloumen del producto en mts cubicos
     * @param peso peso del producto en grms
     * @param id_tipo_categoria identificador de la categoria del produto
     */
    @Modifying
    @Transactional
    @Query(value = "insert into productos (id, nombre, fecha_expiracion, codigo_barras, volumen, peso, id_tipo_categoria) values (ids_producto.nextval, :nombre, :fecha_expiracion, :codigo_barras, :volumen, :peso, :id_tipo_categoria)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("fecha_expiracion") Date fecha_expiracion, @Param("codigo_barras") Integer codigo_barras,@Param("volumen") Float volumen, @Param("peso") Float peso, @Param("id_tipo_categoria") Integer id_tipo_categoria);

    /**
     * RF6.2 : Leer un producto por id o nombre
     * SQL : Recupera el producto de la tabla 'productos' cuyo ID o
     *          nombre coincide con los valores especificados.
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @return collection de el/los productos encontrados
     */
    @Query(value = "SELECT * FROM productos b WHERE id = :id or b.nombre = :nombre", nativeQuery=true)
    Collection<Producto> darproductoPorIdONombre(@Param("id") Integer id ,@Param("nombre") String nombre);

    /**
     * RF6.3 : Actualizar un producto
     * SQL   : -Actualiza los detalles del producto en la tabla 'productos'
     *              para el registro cuyo ID coincide con el valor especificado.
     * @param id identificador del producto
     * @param nombre nombre actulizado
     * @param fecha_expiracion fecha de expiracion actulizada en formato YYYY-MM-DD
     * @param codigo_barras numero actualizado
     * @param volumen valor actualizado
     * @param peso valor actualizado
     * @param id_tipo_categoria identificador de la categoria actualizado
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, fecha_expiracion = :fecha_expiracion, codigo_barras = :codigo_barras, volumen = :volumen, peso = :peso, id_tipo_categoria = :id_tipo_categoria WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("fecha_expiracion") Date fecha_expiracion, @Param("codigo_barras") Integer codigo_barras,@Param("volumen") Float volumen, @Param("peso") Float peso, @Param("id_tipo_categoria") Integer id_tipo_categoria);

}
