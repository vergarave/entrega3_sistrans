package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Alojamiento;

public interface AlojamientoRepo extends JpaRepository <Alojamiento, Integer> {

    @Query(value = "SELECT * FROM alojamientos", nativeQuery = true)
    Collection<Alojamiento> darAlojamientos();

}
    

