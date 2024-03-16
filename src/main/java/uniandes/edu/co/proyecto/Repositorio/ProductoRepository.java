package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query(value = "SELECT * FROM productos")
    Collection<Producto> getProducto();

    @Query(value = "SELECT * FROM productos WHERE id= :id", nativeQuery = true )
    Producto getProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (id, cliente, estado, valorCuenta, monto, diaCorte) VALUES(bancandes_sequence.nextval, :cliente, :estado, :valorCuenta, :monto, :diaCorte", nativeQuery = true )
    void insertarProducto(@Param("cliente") Cliente cliente, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET cliente = :cliente, estado =: estado, valorCuenta =: valorCuenta WHERE id =:id", nativeQuery = true)
    void insertarProducto(@Param("cliente") Cliente cliente, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id =:id", nativeQuery = true)
    void insertarProducto(@Param("cliente") Cliente cliente, @Param("estado") String estado);
  
}