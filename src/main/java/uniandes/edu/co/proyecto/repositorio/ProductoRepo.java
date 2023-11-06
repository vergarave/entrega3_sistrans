package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepo extends JpaRepository <Producto, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (idproducto, nombre, precio) VALUES (parranderos_sequence.nextval, :nombre, :precio)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("precio") Integer precio);


    // Read
    @Query(value = "SELECT * FROM prodcutos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE idproducto = :idproducto", nativeQuery = true)
    Producto darProducto(@Param("idproducto") Integer idproducto);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, precio=:precio WHERE idproducto=:idproducto", nativeQuery = true)
    void actualizarProducto(@Param("idproducto") Integer idproducto, @Param("nombre") String nombre, @Param("precio") Integer precio);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE idproducto =: idproducto", nativeQuery = true)
    void eliminarProducto(@Param("idproducto") Integer idproducto);
}
