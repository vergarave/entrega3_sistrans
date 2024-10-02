package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Documento;

public interface DocumentoRepository extends JpaRepository<Documento,Integer>{

}
