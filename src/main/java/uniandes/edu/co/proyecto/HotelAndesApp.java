package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import uniandes.edu.co.proyecto.modelo.Usuario;

import uniandes.edu.co.proyecto.repositorio.UsuarioRepo;

@SpringBootApplication
public class HotelAndesApp implements CommandLineRunner{

	@Autowired
	private UsuarioRepo usuarioRepo;

	public static void main(String[] args) {
		SpringApplication.run(HotelAndesApp.class, args);
	}

	@Override
	public void run(String ... arg)
	{
		Collection<Usuario> usuarios = usuarioRepo.darUsuarios();
		for(Usuario u: usuarios)
		{
			System.out.println(u);
		}
	}


}
