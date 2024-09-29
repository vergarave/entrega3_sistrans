package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

@RestController
public class CategoriaController {

      @Autowired
    private CategoriaRepository categoriaRepository;

    
    @GetMapping("/categorias")
    public Collection<Categoria> categoria(){
        return categoriaRepository.darCategorias();
    }

     //Este no dicen como hacerlo xd
    @GetMapping("/categorias/{codigo}")
    public ResponseEntity<?> obtenerCategoria(@PathVariable int codigo){
        Categoria categoria = categoriaRepository.darCategoria(codigo);

        // Devolver si existe
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
        // Mensaje personalizado cuando la categoría no existe
            String mensajeError = "Error: La categoría con el código " + codigo + " no existe.";
        return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
    }
    }

    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody Categoria categoria){
        
        try{
            categoriaRepository.insertarCategoria(categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicasAlmacenamiento());
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/categorias/{codigo}/delete")
    public ResponseEntity<String> categoriaEliminar(@PathVariable("codigo") int codigo) {

        categoriaRepository.eliminarCategoria(codigo);
        return new ResponseEntity<>("Categoria eliminada exitosamente", HttpStatus.OK);
    }

}
