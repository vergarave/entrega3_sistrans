package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Ips;

public interface IpsRepository extends MongoRepository<Ips, String> {
}