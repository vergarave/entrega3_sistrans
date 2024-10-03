package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{

    // RF2 : Crear una sucursal
    /**
     * @param nombre
     * @param tamanio
     * @param telefono
     * @param direccion
     * @param id_ciudad
     */
    @Modifying
    @Transactional
    @Query(value = "insert into sucursales (id,nombre,tamanio,telefono,direccion,id_ciudad) values (ids_sucursal.nextval, :nombre, :tamanio, :telefono, :direccion, :id_ciudad)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamanio") String tamanio, @Param("telefono") String telefono,@Param("direccion") String direccion, @Param("id_ciudad") Integer id_ciudad);

}
