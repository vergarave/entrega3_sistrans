package uniandes.edu.co.proyecto.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Medico;

public interface MedicoRepository extends MongoRepository<Medico, String> {

   Optional<Medico> findByRegistroMedico(String registroMedico);

}

