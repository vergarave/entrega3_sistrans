package uniandes.edu.co.proyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.servicios.IngresoProductoService;

@RestController
public class IngresoProductoController {

    @Autowired
    private IngresoProductoService ingresoProductoService;

    @PostMapping("/ingresoProductos")
    public ResponseEntity<?> registrarIngreso(@RequestBody Map<String, Integer> requestBody) {

        Integer idOrdenCompra = requestBody.get("idOrdenCompra");
        Integer idBodega = requestBody.get("idBodega");

        if (idOrdenCompra == null || idBodega == null) {
            return new ResponseEntity<>("Los datos idOrdenCompra y idBodega son obligatorios", HttpStatus.BAD_REQUEST);
        }

        //Llamamos al servicio
        ResponseEntity<?> respuesta = ingresoProductoService.registrarIngresoProductos(idOrdenCompra, idBodega);

        //Damos la respuesta del servicio, ya viene bonita y ordenada
        return respuesta;
    }
}
