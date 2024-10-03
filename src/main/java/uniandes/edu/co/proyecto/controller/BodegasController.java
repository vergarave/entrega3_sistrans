package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@RestController
public class BodegasController {

    @Autowired
    private BodegaRepository bodegaRepository;
}
