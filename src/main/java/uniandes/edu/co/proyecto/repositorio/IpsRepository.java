package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Eps;
import uniandes.edu.co.proyecto.modelo.Ips;

@Repository
public interface IpsRepository extends JpaRepository<Ips, String> {
    
    @Query(value = "SELECT * FROM IPS", nativeQuery = true)
    Collection<Ips> darIpses();

    @Query(value = "SELECT * FROM IPS WHERE NIT = :nit", nativeQuery = true)
    Ips darIps(@Param("nit") String nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPS (NIT, NOMBRE, CIUDAD, DIRECCION, TELEFONO, EPS_NIT) VALUES (:nit, :nombre, :ciudad, :direccion, :telefono, :epsNit)", nativeQuery = true)
    void insertarIps(@Param("nit") String nit, @Param("nombre") String nombre, @Param("ciudad") String ciudad, @Param("direccion") String direccion, @Param("telefono") Integer telefono, @Param("epsNit") Eps epsNit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE IPS SET NOMBRE = :nombre, CIUDAD = :ciudad, DIRECCION = :direccion, TELEFONO = :telefono, EPS_NIT = :epsNit WHERE NIT = :nit", nativeQuery = true)
    void actualizarIps(@Param("nit") String nit, @Param("nombre") String nombre, @Param("ciudad") String ciudad, @Param("direccion") String direccion, @Param("telefono") Integer telefono, @Param("epsNit") Eps epsNit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPS WHERE NIT = :nit", nativeQuery = true)
    void eliminarIps(@Param("nit") String nit);
}
