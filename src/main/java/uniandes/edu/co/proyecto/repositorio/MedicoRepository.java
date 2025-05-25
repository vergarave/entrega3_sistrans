package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import uniandes.edu.co.proyecto.modelo.Medico;

public interface MedicoRepository extends MongoRepository<Medico, String> {

    Medico findByRegistroMedico(String registroMedico);

}

