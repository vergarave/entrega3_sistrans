package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String...arg){

		categoriaRepository.insertarCategoria("PERECEDEROU", "descripcion", "caracteristicasAlmacenamiento");
		System.out.println(2);

		Collection<Categoria> categorias = categoriaRepository.darCategorias();
		for(Categoria b: categorias){
		System.out.println(b.getCodigo());
		}
	}
}
