package uniandes.edu.co.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.ServicioSalud;

public interface ServicioSaludRepository extends MongoRepository<ServicioSalud, String> {
    
    Optional<ServicioSalud> findByCodigo(String codigo);

}

