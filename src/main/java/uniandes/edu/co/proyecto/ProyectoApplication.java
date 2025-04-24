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
import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.repositorio.EpsRepository;
import uniandes.edu.co.proyecto.repositorio.IpsRepository;

@SpringBootApplication
@ComponentScan("uniandes.edu.co.proyecto")
@EnableJpaRepositories("uniandes.edu.co.proyecto.repositorio")
@EntityScan("uniandes.edu.co.proyecto.modelo")
public class ProyectoApplication{

	@Autowired
	private IpsRepository ipsRepo;
	private EpsRepository epsRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	/*@Override
	public void run(String... arg){
		//Eps eps = new Eps("890903433-7", "nombre");
		Eps eps = epsRepo.darEps("890903433-6");
		ipsRepo.insertarIps("1", "2", "3", "4", 123, eps);

		//System.out.println(ips);
		
	}*/

}
