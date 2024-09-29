package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{

    public interface RespuestaPorcentajeOcupacion{
        int getID_BODEGA();
        String getNOMBRE_BODEGA();
        double getPORCENTAJE_OCUPACION();
    }
    
    @Query(value = "SELECT * FROM bodega", nativeQuery=true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM bodega WHERE id= :id", nativeQuery=true)
    Bodega darBodega(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodega(id, nombre, tamanio, capacidad, id_sucursal) VALUES(secuencia_bodega.nextval, :nombre, :tamanio, :capacidad, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("capacidad") Integer capacidad, @Param("id_sucursal") Integer idSucursal);

    @Modifying
    @Transactional
    @Query(value = "DELETE from bodega WHERE id = :id", nativeQuery= true)
    void eliminarBodega(@Param("id") int id);

    //Consulta avanzada No. 1
    @Query(value = "SELECT Bodega.id, Bodega.nombre, (SUM(Producto_En_Bodega.cantidad_En_Bodega) / Bodega.capacidad) AS porcentajeOcupacion FROM Bodega\r\n" +
    "INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.id_Bodega = Bodega.id\r\n" +
    "INNER JOIN Producto ON Producto.identificador = Producto_En_Bodega.identificador_Producto\r\n" +
    "WHERE Bodega.id_sucursal = :idSucursalU\r\n" +
    "AND Producto.identificador IN :listaProductosU\r\n" +
    "GROUP BY Bodega.id, Bodega.nombre, Bodega.capacidad", nativeQuery = true)
    Collection<Object[]> obtenerOcupacionBodegas(@Param("idSucursalU") Integer idSucursalU, @Param("listaProductosU") Collection<Integer> listaProductosU);

}
