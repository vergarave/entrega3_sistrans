package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.OrdenServicio;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio, String> {
}

