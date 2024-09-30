package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;

//Controlador de la entidad OrdenDeCompra que se encarga de realizar las peticiones HTTP
@RestController
public class OrdenDeCompraController {

    //Inyeccion de dependencias
    @Autowired //Inyecta el bean que se encarga de la logica de la aplicacion
    private OrdenDeCompraRepository ordenDeCompraRepository; //Bean de la interfaz OrdenDeCompraRepository

    //Metodo que se encarga de crear una orden de compra
    @PostMapping("/ordenesDeCompra/new/save")
    public ResponseEntity<String> ordenDeCompraGuardar(@RequestBody OrdenDeCompra ordenDeCompra) {
        try {

            //Insertar la orden de compra en la base de datos
            ordenDeCompraRepository.insertarOrdenDeCompra(
                ordenDeCompra.getFechaEntrega(),
                //El estado siempre es VIGENTE
                "VIGENTE",
                //La fecha de creacion es la fecha actual
                LocalDate.now(),
                ordenDeCompra.getIdSucursal().getId(),
                ordenDeCompra.getNitProveedor().getNit()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo que se encarga de editar una orden de compra
    @PostMapping("/ordenesDeCompra/{numero}/edit/save") //Indica que el metodo se activa cuando se hace una peticion POST a la URL /ordenesDeCompra/{numero}/edit/save
    public ResponseEntity<String> ordenDeCompraEditarGuardar(@PathVariable Integer numero) {
        OrdenDeCompra orden = ordenDeCompraRepository.darOrdenDeCompra(numero);
        //Si la orden de compra existe y su estado es VIGENTE
        if (orden != null && "VIGENTE".equals(orden.getEstado())) {
            //Actualizar el estado de la orden de compra a ENTREGADA
            ordenDeCompraRepository.actualizarEstadoOrdenDeCompra(numero, "ANULADA");
            return new ResponseEntity<>("Orden de compra anulada exitosamente", HttpStatus.OK);
        } else if (orden != null && "ENTREGADA".equals(orden.getEstado())) { //Si la orden de compra existe y su estado es ENTREGADA
            return new ResponseEntity<>("No se puede anular una orden de compra entregada", HttpStatus.BAD_REQUEST);
        } else if (orden != null && "ANULADA".equals(orden.getEstado())) { //Si la orden de compra existe y su estado es ANULADA
            return new ResponseEntity<>("La orden de compra ya se encuentra anulada", HttpStatus.BAD_REQUEST);
        }
        else { //Si la orden de compra no existe
            return new ResponseEntity<>("Orden de compra no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    //Metodo que se encarga de devolver todas las ordenes de compra
    @GetMapping("/ordenesDeCompra")
    public Collection<OrdenDeCompra> ordenesDeCompra() {
        return ordenDeCompraRepository.darOrdenesDeCompra();
    }
}
