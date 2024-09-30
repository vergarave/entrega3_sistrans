package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

//Repositorio de la entidad Ciudad que se encarga de realizar las consultas a la base de datos
public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

    //Consulta CRUD de darCiudades
    @Query(value = "SELECT * FROM ciudad", nativeQuery=true)
    Collection<Ciudad> darCiudades();

    //Consulta CRUD de darCiudad
    @Query(value = "SELECT * FROM ciudad WHERE codigo= :codigo", nativeQuery=true)
    Ciudad darCiudad(@Param("codigo") int id);

    //Consulta CRUD de insertarCiudad
    @Modifying //Indica que se va a realizar una modificacion en la base de datos
    @Transactional //Indica que es una transaccion
    @Query(value = "INSERT INTO ciudad(codigo, nombre) VALUES(secuencia_ciudad.nextval, :nombre)", nativeQuery = true)
    void insertarCiudad(@Param("nombre") String nombre);
}
