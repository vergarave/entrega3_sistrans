package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenServicio;
import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.modelo.ServicioSalud;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Integer>{

    @Query(value = "SELECT * FROM ordenesdeservicio", nativeQuery = true)
    Collection<OrdenServicio> darOrdenes();

    @Query(value = "SELECT * FROM ordenesdeservicio WHERE numero = :numero", nativeQuery = true)
    OrdenServicio darOrden(@Param("numero") Integer numero);

    //figure out como importar el enum de estado 
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenesdeservicio (numero, fecha, estado, tipoAfiliadoReceptor, numAfiliadoReceptor, medicoRemitente, servicioNombre) VALUES (proyecto_sequence.nextval, :fecha, :estado, :tipoAfiliadoReceptor, :numAfiliadoReceptor, :medicoRemitente, :servicioNombre)", nativeQuery = true)
    void insertarOrden(@Param("fecha") Date fecha, @Param("estado") String estado, @Param("tipoAfiliadoReceptor") Afiliado tipoAfiliadoReceptor, @Param("numAfiliadoReceptor") Afiliado numAfiliadoReceptor, @Param("medicoRemitente") Medico medicoRemitente, @Param("servicioNombre") ServicioSalud servicioNombre);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenesdeservicio SET fecha = :fecha, estado = :estado, tipoAfiliadoReceptor = :tipoAfiliadoReceptor, numAfiliadoReceptor = :numAfiliadoReceptor, medicoRemitente = :medicoRemitente, servicioNombre = :servicioNombre WHERE numero = :numero", nativeQuery = true)
    void actualizarOrden(@Param("numero") Integer numero, @Param("fecha") Date fecha, @Param("estado") String estado, @Param("tipoAfiliadoReceptor") Afiliado tipoAfiliadoReceptor, @Param("numAfiliadoReceptor") Afiliado numAfiliadoReceptor, @Param("medicoRemitente") Medico medicoRemitente, @Param("servicioNombre") ServicioSalud servicioNombre);
  
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenesdeservicio WHERE numero = :numero", nativeQuery = true)
    void eliminarorden(@Param("numero") Integer numero);
}
