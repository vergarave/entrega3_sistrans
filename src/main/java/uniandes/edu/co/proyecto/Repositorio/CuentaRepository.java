package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,String> {
    @Query(value = "SELECT * FROM cuentas")
    Collection<Cuenta> getCuenta();

    @Query(value = "SELECT * FROM cuentas WHERE id= :id", nativeQuery = true )
    Cuenta getCuenta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id, cliente, estado, dinero) VALUES(bancandes_sequence.nextval, :cliente, :estado, :dinero", nativeQuery = true )
    void insertarCuenta(@Param("cliente") Cliente cliente, @Param("estado") String estado, @Param("dinero") String dinero);


    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET cliente = :cliente, estado =: estado, dinero =: dinero WHERE id =:id", nativeQuery = true)
    void actualizarCuenta(@Param("cliente") Cliente cliente, @Param("estado") String estado, @Param("dinero") String dinero);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id =:id", nativeQuery = true)
    void eliminarCuenta(@Param("cliente") Cliente cliente, @Param("estado") String estado, @Param("dinero") String dinero);
  
}