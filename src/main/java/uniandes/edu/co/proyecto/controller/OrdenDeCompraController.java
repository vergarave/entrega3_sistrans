package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;

//Controlador de la entidad OrdenDeCompra que se encarga de realizar las peticiones HTTP
@Controller
public class OrdenDeCompraController {

    //Inyeccion de dependencias
    @Autowired //Inyecta el bean que se encarga de la logica de la aplicacion
    private OrdenDeCompraRepository ordenDeCompraRepository; //Bean de la interfaz OrdenDeCompraRepository

    //Metodo que se encarga de crear una orden de compra
    @PostMapping("/ordenesDeCompra/new/save")
    public ResponseEntity<String> ordenDeCompraGuardar(@RequestBody OrdenDeCompra ordenDeCompra) {
        try {
            ordenDeCompraRepository.insertarOrdenDeCompra(
                ordenDeCompra.getFechaEntrega(),
                "VIGENTE",  // Estado predeterminado
                LocalDate.now(),  // Fecha de creación actual
                ordenDeCompra.getIdSucursal().getId(),
                ordenDeCompra.getNitProveedor().getNit()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordenesDeCompra/crear")
    public String mostrarFormularioCreacionOrden() {
        return "crearOrdenDeCompra"; // Asegúrate de que el archivo HTML tenga este nombre en tu carpeta de templates
    }



    //Metodo que se encarga de editar una orden de compra
    @PostMapping("/ordenesDeCompra/{numero}/edit/save")
    public ResponseEntity<String> ordenDeCompraEditarGuardar(@PathVariable Integer numero) {
        OrdenDeCompra orden = ordenDeCompraRepository.darOrdenDeCompra(numero);
        if (orden != null && "VIGENTE".equals(orden.getEstado())) {
            ordenDeCompraRepository.actualizarEstadoOrdenDeCompra(numero, "ANULADA");
            return new ResponseEntity<>("Orden de compra anulada exitosamente", HttpStatus.OK);
        } else if (orden != null && "ENTREGADA".equals(orden.getEstado())) {
            return new ResponseEntity<>("No se puede anular una orden de compra entregada", HttpStatus.BAD_REQUEST);
        } else if (orden != null && "ANULADA".equals(orden.getEstado())) {
            return new ResponseEntity<>("La orden de compra ya se encuentra anulada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Orden de compra no encontrada", HttpStatus.NOT_FOUND);
    }


    //Metodo que se encarga de devolver todas las ordenes de compra
    @GetMapping("/ordenesDeCompra")
    public ResponseEntity<Collection<OrdenDeCompra>> ordenesDeCompra() {
        Collection<OrdenDeCompra> ordenes = ordenDeCompraRepository.darOrdenesDeCompra();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }


    @GetMapping("/ordenesDeCompra/ver")
    public String mostrarOrdenesDeCompra() {
        return "verOrdenesDeCompra";
    }


    //Metodo que se encarga de devolver todas las ordenes de compra
    @GetMapping("/MenuOrdenesDeCompra")
    public String menuordenesDeCompra() {
        return "menuOrdenDeCompra";
    }
}
