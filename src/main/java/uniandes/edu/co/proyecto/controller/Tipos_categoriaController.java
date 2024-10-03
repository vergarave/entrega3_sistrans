package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.Tipo_categoriaRepository;

@RestController
public class Tipos_categoriaController {

    @Autowired
    private Tipo_categoriaRepository tipo_categoriaRepository;
}
