package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

    @Query(value = "SELECT * FROM ciudad", nativeQuery=true)
    Collection<Ciudad> darCiudades();

    @Query(value = "SELECT * FROM ciudad WHERE codigo= :codigo", nativeQuery=true)
    Ciudad darCiudad(@Param("codigo") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudad(codigo, nombre) VALUES(secuencia_ciudad.nextval, :nombre)", nativeQuery = true)
    void insertarCiudad(@Param("nombre") String nombre);
}
