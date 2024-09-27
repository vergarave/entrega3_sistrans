package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/ordenes")
public class OrdenDeCompraController {

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;

    // REVISAAAAR XD ESTE ES EL RF7
    @PostMapping("/ordenesDeCompra/new/save")
    public ResponseEntity<String> ordenDeCompraGuardar(@RequestBody OrdenDeCompra ordenDeCompra) {
        try {
            ordenDeCompraRepository.insertarOrdenDeCompra(
                ordenDeCompra.getFechaEntrega(),
                "vigente",
                LocalDate.now(),
                ordenDeCompra.getIdSucursal(),
                ordenDeCompra.getNitProveedor()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // REVISAAAAR XD ESTE ES EL RF8
    @PostMapping("/ordenesDeCompra/{numero}/edit/save")
    public ResponseEntity<String> ordenDeCompraEditarGuardar(@PathVariable Integer numero) {
        OrdenDeCompra orden = ordenDeCompraRepository.darOrdenDeCompra(numero);
        if (orden != null && "vigente".equals(orden.getEstado())) {
            ordenDeCompraRepository.actualizarEstadoOrdenDeCompra(numero, "anulada");
            return new ResponseEntity<>("Orden de compra anulada exitosamente", HttpStatus.OK);
        } else if (orden != null && "entregada".equals(orden.getEstado())) {
            return new ResponseEntity<>("No se puede anular una orden de compra entregada", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Orden de compra no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Este si debe estar bien pero no sé, revisen pliss, es el RF9
    @GetMapping("/ordenesDeCompra")
    public Collection<OrdenDeCompra> ordeneDeCompra() {
        return ordenDeCompraRepository.darOrdenesDeCompra();
    }
}
