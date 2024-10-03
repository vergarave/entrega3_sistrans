package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Contiene;
import uniandes.edu.co.proyecto.modelo.ContienePK;

public interface ContieneRepository extends JpaRepository<Contiene,ContienePK>{

}
