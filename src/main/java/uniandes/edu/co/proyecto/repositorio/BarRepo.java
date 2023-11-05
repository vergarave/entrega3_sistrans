package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepo extends JpaRepository <Bar, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (idbar, nombre, capacidad, tipo, ubicacion, horario, idhotel) VALUES (parranderos_sequence.nextval, :nombre, :capacidad, :tipo, :ubicacion, :horario, :idhotel)", nativeQuery = true)
    void insertarBar(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("tipo") String tipo, 
                            @Param("ubicacion") String ubicacion, @Param("horario") String horario, @Param("idhotel") Integer idhotel);


    // Read
}
