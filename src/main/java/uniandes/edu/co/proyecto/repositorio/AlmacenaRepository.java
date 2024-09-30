package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Almacena;

public interface AlmacenaRepository extends JpaRepository<Almacena,Integer> {

    @Query(value = "SELECT * FROM almacena", nativeQuery = true)
    Collection<Almacena> darAlmacena();
}
