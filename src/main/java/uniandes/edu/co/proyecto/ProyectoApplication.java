package uniandes.edu.co.proyecto;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	
	@Autowired
	private OrdenDeCompraRepository ordenDeCompraRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	public void run(String...arg) {
		Collection<OrdenDeCompra> ordenes = ordenDeCompraRepository.darOrdenesDeCompra();
		for (OrdenDeCompra o: ordenes) {
			System.out.println(o);
		}
	}

}
