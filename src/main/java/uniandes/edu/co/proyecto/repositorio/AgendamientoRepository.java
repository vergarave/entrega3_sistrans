package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Agendamiento;

public interface AgendamientoRepository extends MongoRepository<Agendamiento, String> {
}

