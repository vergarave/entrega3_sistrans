package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Afiliado;

public interface AfiliadoRepository extends MongoRepository<Afiliado, String> {
}

