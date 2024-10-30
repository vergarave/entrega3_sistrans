package uniandes.edu.co.proyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.servicios.IngresoProductoService;

@RestController
@RequestMapping("/api")
public class IngresoProductoController {

    @Autowired
    private IngresoProductoService ingresoProductoService;

    @PostMapping("/ingresoProductos")
    public ResponseEntity<Map<String, Object>> registrarIngreso(@RequestBody Map<String, Integer> requestBody) {
        Integer idOrdenCompra = requestBody.get("idOrdenCompra");
        Integer idBodega = requestBody.get("idBodega");

        if (idOrdenCompra == null || idBodega == null) {
            return new ResponseEntity<>(Map.of("message", "Los campos idOrdenCompra y idBodega son obligatorios"), HttpStatus.BAD_REQUEST);
        }

        // Llamada al servicio para registrar el ingreso de productos
        Map<String, Object> response = ingresoProductoService.registrarIngresoProductos(idOrdenCompra, idBodega);

        // Verificar si la respuesta contiene un mensaje de error
        if (response.containsKey("message") && response.get("message").toString().contains("no es válida") || 
            response.get("message").toString().contains("no existe") || 
            response.get("message").toString().contains("no pertenece")) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Si no hay errores, retornar con status OK
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

