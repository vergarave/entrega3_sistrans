package uniandes.edu.co.proyecto.repositorio;


import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    @Query(value = "SELECT * FROM producto", nativeQuery=true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM producto WHERE id= :identificador", nativeQuery=true)
    Producto darProducto(@Param("identificador") int identificador);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto( identificador, nombre, costo_en_bodega, presentacion, cantidad_presentacion, unidad_medida, volumen_empaque, peso_empaque, fecha_expiracion, codigo_de_barras, clasificacion_categoria) VALUES(secuencia_producto.nextval, :nombre, :costo_en_bodega, :presentacion, :cantidad_presentacion, :unidad_medida, :volumen_empaque, :peso_empaque, :fecha_expiracion, :codigo_de_barras, :clasificacion_categoria)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo_en_bodega") Double costoEnBodega, @Param("presentacion") String presentacion, @Param("cantidad_presentacion") Double cantidadPresentacion, @Param("unidad_medida") String unidadMedida, 
                          @Param("volumen_empaque") String volumenEmpaque, @Param("peso_empaque") String pesoEmpaque, @Param("fecha_expiracion")LocalDate fechaExpiracion, @Param("codigo_de_barras") String codigoDeBarras, @Param("clasificacion_categoria") Categoria clasificacionCategoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre = :nombre, costo_en_bodega = :costo_en_bodega, presentacion = :presentacion,cantidad_presentacion = :cantidad_presentacion,unidad_medida = :unidad_medida,volumen_empaque = :volumen_empaque, peso_empaque = :peso_empaque, fecha_expiracion = :fecha_expiracion, codigo_de_barras = :codigo_de_barras, clasificacion_categoria = :clasificacion_categoria WHERE identificador = :identificador", nativeQuery = true)
    void actualizarProducto(@Param("identificador")Integer identificador, @Param("nombre") String nombre, @Param("costo_en_bodega") Double costoEnBodega, @Param("presentacion") String presentacion, @Param("cantidad_presentacion") Double cantidadPresentacion, 
                          @Param("unidad_medida") String unidadMedida, @Param("volumen_empaque") String volumenEmpaque, @Param("peso_empaque") String pesoEmpaque, @Param("fecha_expiracion")LocalDate fechaExpiracion, @Param("codigo_de_barras") String codigoDeBarras, @Param("clasificacion_categoria") Categoria clasificacionCategoria);                      
    @Modifying
    @Transactional
    @Query(value = "DELETE from producto WHERE identificador = :identificador", nativeQuery= true)
    void eliminarProducto(@Param("identificador") int identificador);
}
