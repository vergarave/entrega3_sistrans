package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Eps;

@Repository
public interface EpsRepository extends JpaRepository<Eps, String>{
    
    @Query(value = "SELECT * FROM eps", nativeQuery = true)
    Collection<Eps> darEpses();

    @Query(value = "SELECT * FROM eps WHERE nit = :nit", nativeQuery = true)
    Eps darEps(@Param("nit") String nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO eps (nit, nombre) VALUES(:nit, :nombre)", nativeQuery = true)
    void insertarEps(@Param("nit") String nit, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE eps SET nombre = :nombre WHERE nit = :nit", nativeQuery = true)
    void actualizarEps(@Param("nit") String nit, @Param("nombre") String nombre);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM eps WHERE nit = :nit", nativeQuery = true)
    void eliminarEps(@Param("nit") String nit);
}
