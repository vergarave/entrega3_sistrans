package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.alojamientos;

public interface alojamientosRepo extends JpaRepository <alojamientos, Integer> {

    Collection<alojamientos> darAlojamientos();


}
    

