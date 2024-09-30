package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

//Repositorio de la entidad Categoria que se encarga de realizar las consultas a la base de datos
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    //Consulta CRUD de darCategorias
    @Query(value = "SELECT * FROM categoria", nativeQuery=true)
    Collection<Categoria> darCategorias();

    //Consulta CRUD de darCategoria por codigo
    @Query(value = "SELECT * FROM categoria WHERE codigo= :codigo", nativeQuery=true)
    Categoria darCategoriaPorCodigo(@Param("codigo") int codigo);

    //Consulta CRUD de darCategoria por nombre
    @Query(value = "SELECT * FROM categoria WHERE nombre= :nombre", nativeQuery=true)
    Categoria darCategoriaPorNombre(@Param("nombre") String nombre);

    //Consulta CRUD de insertarCategoria
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "INSERT INTO categoria(codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES(secuencia_categoria.nextval, :nombre, :descripcion, :caracteristicas_almacenamiento)", nativeQuery = true)
    void insertarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas_almacenamiento") String caracteristicasAlmacenamiento);

    //Consulta CRUD de eliminarCategoria
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "DELETE from categoria WHERE codigo = :codigo", nativeQuery= true)
    void eliminarCategoria(@Param("codigo") int codigo);
}
