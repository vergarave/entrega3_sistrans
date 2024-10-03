package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Tipo_categoria;

public interface Tipo_categoriaRepository extends JpaRepository<Tipo_categoria,Integer>{

    /**
     * RF5.1 : Crear una categoria
     * SQL   : Inserta un nuevo tipo de categoría en la tabla 'tipos_categoria' con
     *              un ID generado automáticamente y valores específicos para nombre,
     *              descripción y características.
     * @param nombre nombre de la categoria
     * @param descripcion datos importantes de la categoria
     * @param caracteristicas detalles de almacenamiento especificos
     */
    @Modifying
    @Transactional
    @Query(value = "insert into tipos_categoria (id,nombre,descripcion,caracteristicas) values (ids_tipo_categoria.nextval, :nombre, :descripcion, :caracteristicas)", nativeQuery = true)
    void insertarTipo_categoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    /**
     * RF5.2 : Leer una categoria por id o nombre
     * SQL   : Recupera el tipo de categoría de la tabla 'tipos_categoria' cuyo ID o nombre
     *              coincide con los valores especificados.
     * @param id identificado unico de la categoria
     * @param nombre nombre de la categoria
     * @return collection con la categoria(s) encontrada(s)
     */
    @Query(value = "SELECT * FROM tipos_categoria WHERE id = :id or nombre = :nombre", nativeQuery = true)
    Collection<Tipo_categoria> darTipo_categoriaPorIdONombre(@Param("id") Integer id, @Param("nombre") String nombre);

    /**
     * Obtener la ultima categoria creada
     * @return collection con un unico elemento que sera el ultimo id creado
     */
    @Query(value = "SELECT * FROM tipos_categoria WHERE id = (SELECT MAX(id) FROM tipos_categoria)", nativeQuery = true)
    Collection<Tipo_categoria> getLast();

}
