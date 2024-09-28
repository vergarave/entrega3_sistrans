package uniandes.edu.co.proyecto.repositorio;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {

    @Query(value = "SELECT * FROM orden_de_compra", nativeQuery=true)
    Collection<OrdenDeCompra> darOrdenesDeCompra();

    @Query(value = "SELECT * FROM orden_de_compra WHERE numero= :numero", nativeQuery=true)
        OrdenDeCompra darOrdenDeCompra(@Param("numero") Integer numero);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orden_de_compra(numero, fecha_entrega, estado, fecha_creacion, nit_proveedor) VALUES(secuencia_orden_de_compra.nextval, :fecha_entrega, :estado, :fecha_creacion, :nit_proveedor)", nativeQuery = true)
    void insertarOrdenDeCompra(@Param("fecha_entrega") LocalDate fechaEntrega, @Param("estado") String estado, @Param("fecha_creación") LocalDate fechaCreacion, @Param("id_sucursal") Sucursal idSucursal, @Param("nit_proveedor") Proveedor nitProveedor);

    @Modifying
    @Transactional
    @Query(value = "UPDATE orden_de_compra SET estado = :estado WHERE numero = :numero", nativeQuery = true)
    void actualizarEstadoOrdenDeCompra(@Param("numero") Integer numero, @Param("estado") String estado);

}
