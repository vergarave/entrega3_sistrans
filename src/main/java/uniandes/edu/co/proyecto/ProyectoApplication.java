package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import uniandes.edu.co.proyecto.modelo.Eps;
import uniandes.edu.co.proyecto.repositorio.EpsRepository;

@SpringBootApplication
@ComponentScan("uniandes.edu.co.proyecto")
@EnableJpaRepositories("uniandes.edu.co.proyecto.repositorio")
@EntityScan("uniandes.edu.co.proyecto.modelo")
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private EpsRepository epsRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... arg){
		Collection<Eps> eps = epsRepo.darEpses();
		for(Eps e: eps){
			System.out.println(e);
		}
	}

}
