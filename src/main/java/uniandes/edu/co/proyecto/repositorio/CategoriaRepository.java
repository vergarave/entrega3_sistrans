package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "SELECT * FROM categoria", nativeQuery=true)
    Collection<Categoria> darCategoria();

    @Query(value = "SELECT * FROM categoria WHERE id= :id", nativeQuery=true)
    Bodega darCategoria(@Param("id") int id);


}
