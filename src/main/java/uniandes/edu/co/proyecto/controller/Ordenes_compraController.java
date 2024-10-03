package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.Orden_compraRepository;

@RestController
public class Ordenes_compraController {

    @Autowired
    private Orden_compraRepository orden_compraRepository;
}
