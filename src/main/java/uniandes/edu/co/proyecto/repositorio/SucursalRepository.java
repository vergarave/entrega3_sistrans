package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{

@Query(value = "SELECT * FROM sucursal", nativeQuery=true)
    Collection<Sucursal> darSucursales();

@Query(value = "SELECT * FROM sucursal WHERE id= :id", nativeQuery=true)
    Sucursal darSucursal(@Param("id") int id);

@Modifying
@Transactional
@Query(value = "INSERT INTO sucursal(id, nombre, tamanio, direccion, telefono, codigo_ciudad) VALUES(secuencia_bodega.nextval, :nombre, :tamanio, :direccion, :telefono, :codigo_ciudad)", nativeQuery = true)
void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") Double tamanio, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("codigo_ciudad") Integer codigoCiudad);


}
