package uniandes.edu.co.proyecto;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	
	@Autowired
	private ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	public void run(String...arg) {
		Collection<Producto> productos = productoRepository.darProductos();
	}

}
