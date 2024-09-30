package uniandes.edu.co.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public void run(String... arg)
	{
		sucursalRepository.insertarSucursal("Calle 39i sur", 315705, "laSucursal", 2);
	}


}
