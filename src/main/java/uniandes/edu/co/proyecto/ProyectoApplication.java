package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.MedicoPersonal;
import uniandes.edu.co.proyecto.repositorio.MedicoPersonalRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private MedicoPersonalRepository medsPersonalRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... arg){
		Collection<MedicoPersonal> medsPersonal = medsPersonalRepo.darMedicosPersonal();
		for(MedicoPersonal mp: medsPersonal){
			System.out.println(mp);
		}
	}

}
