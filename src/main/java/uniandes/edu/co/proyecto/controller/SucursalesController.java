package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
public class SucursalesController {

    @Autowired
    private SucursalRepository sucursalRepository;
}
