package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

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

    /**
     * Obtener el ultimo producto creado
     * @return collection con un unico elemento que sera el ultimo id creado
     */
    @Query(value = "SELECT * FROM productos WHERE id = (SELECT MAX(id) FROM productos)", nativeQuery = true)
    Collection<Producto> getLast();

    /**
     * RFC1 : Mostrar el indice de ocupacion de cada una de las bodegas
     * @param lista_productos lista con los ids de los productos que se quieren consultar
     * @return collection con el resultado de la consulta
     */
    @Query(value = "SELECT co.id_bodega, pr.id id_producto, (SUM(co.cantidad)/co.capacidad) porcentaje_ocupacion FROM contiene co JOIN productos pr ON co.id_producto = pr.id WHERE pr.id IN (:lista_productos) GROUP BY co.id_bodega, pr.id, co.capacidad ORDER BY pr.id ASC, co.id_bodega ASC", nativeQuery = true)
    Collection<Object[]> darPorcentajeOcupacion(@Param("lista_productos") List<Integer> lista_productos);

    /**
     * RFC2.1 : Mostrar los productos que cumplen con estar en un rango de precios
     * @param minPrice valor inferior del rango
     * @param maxPrice valor superior del rango
     * @return
     */
    @Query(value = "select co.id_bodega, bo.nombre, pr.*, co.costo_promedio precio, tc.nombre from contiene co join productos pr on co.id_producto = pr.id join bodegas bo on co.id_bodega = bo.id join tipos_categoria tc on pr.id_tipo_categoria = tc.id where co.costo_promedio between :minPrice and :maxPrice order by pr.id ASC, co.costo_promedio DESC", nativeQuery = true)
    Collection<Object[]> darProductosEnRangoDePrecios(@Param("minPrice") Float minPrice, @Param("maxPrice") Float maxPrice);

    /**
     * RFC2.2 Mostrar los producotscon fecha de vencimiento posterior o inferior a una fecha dada
     * @param minFecha rango inferior de la busqueda
     * @param maxFecha rango superior de la busqueda
     * @return collection con los productos encontrados
     */
    @Query(value = "select * from productos where fecha_expiracion between :minFecha and :maxFecha", nativeQuery = true)
    Collection<Producto> darProductosEnRangoDeFechaDeVencimiento(@Param("minFecha") Date minFecha, @Param("maxFecha") Date maxFecha);
}
