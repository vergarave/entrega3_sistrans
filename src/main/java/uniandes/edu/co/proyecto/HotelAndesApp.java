package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Alojamiento;
import uniandes.edu.co.proyecto.repositorio.AlojamientoRepo;

@SpringBootApplication
public class HotelAndesApp implements CommandLineRunner{

	@Autowired
	private AlojamientoRepo alojamientoRepo;

	public static void main(String[] args) {
		SpringApplication.run(HotelAndesApp.class, args);
	}

	@Override
	public void run(String ... arg)
	{
		Collection<Alojamiento> alojamientos = alojamientoRepo.darAlojamientos();
		for(Alojamiento a: alojamientos)
		{
			System.out.println(a);
		}
	}


}
