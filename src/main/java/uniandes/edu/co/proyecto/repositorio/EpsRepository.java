package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Eps;

public interface EpsRepository extends JpaRepository<Eps, String >{
    
    @Query(value = "SELECT * FROM eps", nativeQuery = true)
    Collection<Eps> darEpses();

    @Query(value = "SELECT * FROM eps WHERE nit = :nit", nativeQuery = true)
    Eps darEps(@Param("nit") String nit);

    @Query(value = "INSERT INTO eps (nit, nombre) VALUES(proyecto_sequence.nextval, :nit, :nombre)", nativeQuery = true)
    void insertarEps(@Param("nit") String nit, @Param("nombre") String nombre);
}
