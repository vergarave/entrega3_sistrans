package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

//Repositorio de la entidad Bodega que se encarga de realizar las consultas a la base de datos
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{  

    //Consulta CRUD de getBodegas
    @Query(value = "SELECT * FROM bodega", nativeQuery=true)
    Collection<Bodega> darBodegas();

    //Consulta CRUD de getBodega
    @Query(value = "SELECT * FROM bodega WHERE id= :id", nativeQuery=true)
    Bodega darBodega(@Param("id") int id);

    //Consulta CRUD de insertarBodega
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "INSERT INTO bodega(id, nombre, tamanio, capacidad, id_sucursal) VALUES(secuencia_bodega.nextval, :nombre, :tamanio, :capacidad, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("capacidad") Integer capacidad, @Param("id_sucursal") Integer idSucursal);

    //Consulta CRUD de eliminarBodega
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "DELETE from bodega WHERE id = :id", nativeQuery= true)
    void eliminarBodega(@Param("id") int id);

    //Consulta Avanzada No. 1
    //Consulta que permite obtener la ocupacion de las bodegas de una sucursal dados unos productos
    @Query(value = "SELECT Bodega.id, Bodega.nombre, (SUM(Producto_En_Bodega.cantidad_En_Bodega) / Bodega.capacidad) AS porcentajeOcupacion FROM Bodega\r\n" +
    "INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.id_Bodega = Bodega.id\r\n" +
    "INNER JOIN Producto ON Producto.identificador = Producto_En_Bodega.identificador_Producto\r\n" +
    "WHERE Bodega.id_sucursal = :idSucursalU\r\n" +
    "AND Producto.identificador IN :listaProductosU\r\n" +
    "GROUP BY Bodega.id, Bodega.nombre, Bodega.capacidad", nativeQuery = true)
    Collection<Object[]> obtenerOcupacionBodegas(@Param("idSucursalU") Integer idSucursalU, @Param("listaProductosU") Collection<Integer> listaProductosU);

}
