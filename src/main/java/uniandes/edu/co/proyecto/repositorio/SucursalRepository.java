package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{

@Query(value = "SELECT * FROM sucursal", nativeQuery=true)
    Collection<Sucursal> darSucursales();

@Query(value = "SELECT * FROM sucursal WHERE id= :id", nativeQuery=true)
    Sucursal darSucursal(@Param("id") int id);

@Modifying
@Transactional
@Query(value = "INSERT INTO sucursal(id, nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES(secuencia_sucursal.nextval, :nombre, :tamanio, :direccion, :telefono, :codigo_ciudad)", nativeQuery = true)
void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("codigo_ciudad") Integer codigoCiudad);

//Consulta Avanzada No. 4

@Query(value = "SELECT DISTINCT Sucursal.*\r\n" +
    "FROM Sucursal INNER JOIN Bodega ON Sucursal.id = Bodega.id_sucursal\r\n" +
    "INNER JOIN Producto_En_Bodega ON Bodega.id = Producto_En_Bodega.id_bodega\r\n" +
    "INNER JOIN Producto ON Producto_En_Bodega.identificador_producto = Producto.identificador\r\n" +
    "WHERE (Producto.identificador = :idProductoU OR Producto.nombre = :nombreProductoU)\r\n" +
    "AND Producto_En_Bodega.cantidad_En_Bodega > 0", nativeQuery=true)
Collection<Sucursal> darSucursalesConProducto(@Param("idProductoU") int idProductoU, @Param("nombreProductoU") String nombreProductoU);

@Query(value = "SELECT DISTINCT Sucursal.*\r\n" +
    "FROM Sucursal INNER JOIN Bodega ON Sucursal.id = Bodega.id_sucursal\r\n" +
    "INNER JOIN Producto_En_Bodega ON Bodega.id = Producto_En_Bodega.id_bodega\r\n" +
    "INNER JOIN Producto ON Producto_En_Bodega.identificador_producto = Producto.identificador\r\n" +
    "WHERE Producto.identificador = :idProductoU\r\n" +
    "AND Producto_En_Bodega.cantidad_En_Bodega > 0", nativeQuery=true)
Collection<Sucursal> darSucursalesConProductoIdentificador(@Param("idProductoU") int idProductoU);

@Query(value = "SELECT DISTINCT Sucursal.*\r\n" +
    "FROM Sucursal INNER JOIN Bodega ON Sucursal.id = Bodega.id_sucursal\r\n" +
    "INNER JOIN Producto_En_Bodega ON Bodega.id = Producto_En_Bodega.id_bodega\r\n" +
    "INNER JOIN Producto ON Producto_En_Bodega.identificador_producto = Producto.identificador\r\n" +
    "WHERE Producto.nombre = :nombreProductoU\r\n" +
    "AND Producto_En_Bodega.cantidad_En_Bodega > 0", nativeQuery=true)
Collection<Sucursal> darSucursalesConProductoNombre(@Param("nombreProductoU") String nombreProductoU);


}
