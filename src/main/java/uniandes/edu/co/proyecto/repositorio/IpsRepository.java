package uniandes.edu.co.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Ips;

public interface IpsRepository extends MongoRepository<Ips, String> {
    Optional<Ips> findByNit(String nit);
}