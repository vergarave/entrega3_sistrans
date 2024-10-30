package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ProductoEnBodega;
import uniandes.edu.co.proyecto.modelo.ProductoEnBodegaPK;

public interface ProductoEnBodegaRepository extends JpaRepository<ProductoEnBodega, ProductoEnBodegaPK> {

    // Consulta nativa para obtener un producto específico en una bodega específica
    @Query(value = "SELECT * FROM PRODUCTO_EN_BODEGA WHERE IDENTIFICADOR_PRODUCTO = :idProducto AND ID_BODEGA = :idBodega", nativeQuery = true)
    ProductoEnBodega findByProductoYBodega(@Param("idProducto") Integer idProducto, @Param("idBodega") Integer idBodega);
}
