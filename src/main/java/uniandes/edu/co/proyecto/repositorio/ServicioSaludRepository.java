package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.ServicioSalud;

public interface ServicioSaludRepository extends MongoRepository<ServicioSalud, String> {
}

