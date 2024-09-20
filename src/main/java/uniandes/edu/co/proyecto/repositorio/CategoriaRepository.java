package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "SELECT * FROM categoria", nativeQuery=true)
    Collection<Categoria> darCategorias();

    @Query(value = "SELECT * FROM categoria WHERE codigo= :codigo", nativeQuery=true)
    Categoria darCategoria(@Param("codigo") int codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categoria(codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES(secuencia_categoria.nextval, :nombre, :descripcion, :caracteristicas_almacenamiento)", nativeQuery = true)
    void insertarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas_almacenamiento") String caracteristicasAlmacenamiento);
}
