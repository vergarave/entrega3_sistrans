package uniandes.edu.co.proyecto.repositorio;


import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

//Repositorio de la entidad Producto que se encarga de realizar las consultas a la base de datos
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    //Consulta para verificar si existe un producto con un identificador
    @Query("SELECT COUNT(p) > 0 FROM Producto p WHERE p.identificador = :identificador")
    boolean existeProducto(@Param("identificador") Integer identificador);

    //Consulta CRUD de darProductos
    @Query(value = "SELECT * FROM producto", nativeQuery=true)
    Collection<Producto> darProductos();

    //Consulta CRUD de darProducto
    @Query(value = "SELECT * FROM producto WHERE identificador= :identificador", nativeQuery=true)
    Producto darProducto(@Param("identificador") int identificador);

    //Consulta CRUD de insertarProducto
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "INSERT INTO producto( identificador, nombre, costo_en_bodega, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, codigo_de_barras, clasificacion_categoria) VALUES(secuencia_producto.nextval, :nombre, :costo_en_bodega, :presentacion, :cantidad_presentacion, :unidad_medida, :volumen_empaque, :peso_empaque, :fecha_expiracion, :codigo_de_barras, :clasificacion_categoria)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo_en_bodega") Double costoEnBodega, @Param("presentacion") String presentacion, @Param("cantidad_presentacion") Double cantidadPresentacion, @Param("unidad_medida") String unidadMedida, 
                          @Param("volumen_empaque") String volumenEmpaque, @Param("peso_empaque") String pesoEmpaque, @Param("fecha_expiracion")LocalDate fechaExpiracion, @Param("codigo_de_barras") String codigoDeBarras, @Param("clasificacion_categoria") Integer clasificacionCategoria);

    //Consulta CRUD de actualizarProducto
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "UPDATE producto SET nombre = :nombre, costo_en_bodega = :costo_en_bodega, presentacion = :presentacion,cantidad_presentacion = :cantidad_presentacion,unidad_medida = :unidad_medida,volumen_empaque = :volumen_empaque, peso_empaque = :peso_empaque, fecha_expiracion = :fecha_expiracion, codigo_de_barras = :codigo_de_barras, clasificacion_categoria = :clasificacion_categoria WHERE identificador = :identificador", nativeQuery = true)
    void actualizarProducto(@Param("identificador")Integer identificador, @Param("nombre") String nombre, @Param("costo_en_bodega") Double costoEnBodega, @Param("presentacion") String presentacion, @Param("cantidad_presentacion") Double cantidadPresentacion, 
                          @Param("unidad_medida") String unidadMedida, @Param("volumen_empaque") String volumenEmpaque, @Param("peso_empaque") String pesoEmpaque, @Param("fecha_expiracion")LocalDate fechaExpiracion, @Param("codigo_de_barras") String codigoDeBarras, @Param("clasificacion_categoria") Integer clasificacionCategoria);
     
    //Consulta CRUD de eliminarProducto                      
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "DELETE from producto WHERE identificador = :identificador", nativeQuery= true)
    void eliminarProducto(@Param("identificador") int identificador);

    //Consulta Avanzada No. 2
    //Consulta que permite obtener los productos que cumplen con los filtros dados
    @Query(value = "SELECT DISTINCT Producto.* FROM Producto\r\n " +
    "INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.identificador_Producto = Producto.identificador\r\n " +
    "INNER JOIN Bodega ON Bodega.id = Producto_En_Bodega.id_Bodega\r\n " +
    "INNER JOIN Sucursal ON Sucursal.id = Bodega.id_sucursal\r\n " +
    "INNER JOIN Categoria ON Categoria.codigo = Producto.clasificacion_categoria\r\n " +
    "WHERE (:precioMinU IS NULL OR Producto.costo_en_bodega >= :precioMinU)\r\n " +
    "AND (:precioMaxU IS NULL OR Producto.costo_en_bodega <= :precioMaxU)\r\n " +
    "AND (:fechaSuperiorU IS NULL OR Producto.fecha_expiracion < TO_DATE(:fechaSuperiorU, 'YYYY-MM-DD'))\r\n " +
    "AND (:fechaInferiorU IS NULL OR Producto.fecha_expiracion > TO_DATE(:fechaInferiorU, 'YYYY-MM-DD'))\r\n " +
    "AND (:sucursalIdU IS NULL OR Bodega.id_sucursal = :sucursalIdU)\r\n " +
    "AND (:categoriaNombreU IS NULL OR Categoria.nombre = :categoriaNombreU)", 
    nativeQuery = true)
    Collection<Producto> darProductosFiltrados(@Param("precioMinU") Double precioMinU, @Param("precioMaxU") Double precioMaxU, @Param("fechaSuperiorU") String fechaSuperiorU, @Param("fechaInferiorU") String fechaInferiorU, @Param("sucursalIdU") Integer sucursalIdU, @Param("categoriaNombreU") String categoriaNombreU);

    //Consulta Avanzada No. 3
    //Consulta que permite obtener los productos y su informacion en una bodega dada de una sucursal dada
    @Query(value = "SELECT PRODUCTO.IDENTIFICADOR, PRODUCTO.NOMBRE, PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN, PRODUCTO_EN_BODEGA.COSTO_PROMEDIO, PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA\r\n" +
    "FROM PRODUCTO\r\n" +
    "INNER JOIN PRODUCTO_EN_BODEGA ON PRODUCTO_EN_BODEGA.IDENTIFICADOR_PRODUCTO = PRODUCTO.IDENTIFICADOR\r\n" +
    "INNER JOIN BODEGA ON BODEGA.ID = PRODUCTO_EN_BODEGA.ID_BODEGA\r\n" +
    "INNER JOIN SUCURSAL ON SUCURSAL.ID = BODEGA.ID_SUCURSAL\r\n" +
    "WHERE SUCURSAL.ID =:idSucursal\r\n" +
    "AND BODEGA.id = :idBodega", nativeQuery = true)
    Collection<Object[]> darProductosBodega(@Param("idSucursal") Integer idSucursal, @Param("idBodega") Integer idBodega);

    //Consulta Avanzada No. 5
    //Consulta que permite obtener los productos que estan por debajo del nivel de reorden
    @Query(value = "SELECT PRODUCTO.IDENTIFICADOR, PRODUCTO.NOMBRE, BODEGA.NOMBRE AS BODEGA_NOMBRE, SUCURSAL.NOMBRE AS SUCURSAL_NOMBRE, PROVEEDOR.NOMBRE AS PROVEEDOR_NOMBRE, PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA, PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN \r\n" +
    "FROM PRODUCTO \r\n" +
    "INNER JOIN PRODUCTO_EN_BODEGA ON PRODUCTO.IDENTIFICADOR = PRODUCTO_EN_BODEGA.IDENTIFICADOR_PRODUCTO \r\n" +
    "INNER JOIN BODEGA ON PRODUCTO_EN_BODEGA.ID_BODEGA = BODEGA.ID \r\n" +
    "INNER JOIN SUCURSAL ON BODEGA.ID_SUCURSAL = SUCURSAL.ID \r\n" +
    "INNER JOIN PRODUCTO_PROVEEDOR ON PRODUCTO.IDENTIFICADOR = PRODUCTO_PROVEEDOR.IDENTIFICADOR_PRODUCTO \r\n" +
    "INNER JOIN PROVEEDOR ON PRODUCTO_PROVEEDOR.NIT_PROVEEDOR = PROVEEDOR.NIT \r\n" +
    "WHERE PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA < PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN \r\n" +
    "ORDER BY PRODUCTO.NOMBRE, BODEGA.NOMBRE", nativeQuery = true)
    Collection<Object[]> obtenerProductosBajoNivelReorden();

}
