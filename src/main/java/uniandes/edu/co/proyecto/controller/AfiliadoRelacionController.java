package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.AfiliadoRelacion;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRelacionRepository;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;

@RestController
public class AfiliadoRelacionController {

    
    @Autowired
    AfiliadoRelacionRepository afiliadoRelacionRepository;

    @Autowired
    AfiliadoRepository afiliadoRepository;

    @GetMapping("/afiliadosRelaciones")
    public String afiliadosRelaciones(Model model) {
        model.addAttribute("afiliadosRelaciones", afiliadoRelacionRepository.darAfiliadoRelaciones());
        return "afiliadosRelaciones";
    }

    @GetMapping("/afiliadosRelaciones/new")
    public String afiliadoRelacionForm(Model model) {
        model.addAttribute("afiliadoRelacion", new AfiliadoRelacion());
        return "afiliadoRelacionNuevo";
    }
    
    @PostMapping("/afiliadosRelaciones/new/save")
    public String afiliadoRelacionGuardar(@ModelAttribute AfiliadoRelacion arel) {
        afiliadoRelacionRepository.insertarAfiliadoRelacion(arel.getNumDoc(), arel.getPkAfiliadoRel().getNumDoc(),
                                            arel.getTipoAfiliado().toString(), arel.getRelacionParentesco());
        return "redirect:/afiliadosRelaciones";

    }

    @GetMapping("/afiliadosRelaciones/{NUMERO_DOCUMENTO}/edit")
    public Optional<AfiliadoRelacion> afiliadoRelacionEditarForm(@PathVariable("NUMERO_DOCUMENTO") int numDoc, @PathVariable("AFILIADO_RELACIONADO_NUM") int doc2) {
        return afiliadoRelacionRepository.darAfiliadoRelacion(numDoc, doc2);
    }

    @PostMapping("/afiliadosRelaciones/{NUMERO_DOCUMENTO}/edit/save")
    public AfiliadoRelacion afiliadoRelacionEditarGuardar(@PathVariable("NUMERO_DOCUMENTO") int numDoc, @ModelAttribute AfiliadoRelacion afiliadoRelacion, @PathVariable("AFILIADO_RELACIONADO_NUM") int doc2) {
        afiliadoRelacionRepository.actualizarAfiliadoRelacion(
            numDoc, doc2,
            afiliadoRelacion.getTipoAfiliado().toString(), 
            afiliadoRelacion.getRelacionParentesco()
        );
        return afiliadoRelacion; 
    }


    @GetMapping("/afiliadosRelaciones/{NUMERO_DOCUMENTO}/delete")
    public void afiliadoEliminar(@PathVariable("NUMERO_DOCUMENTO") int numDoc, @PathVariable("AFILIADO_RELACIONADO_NUM") int doc2)  {
        afiliadoRelacionRepository.eliminarAfiliadoRelacion(numDoc, doc2);
    }
    

    // @GetMapping("/afiliadosRelacione/{NUMERO_DOCUMENTO}/edit")
    // public String afiliadoRelacionEditarForm(@PathVariable("NUMERO_DOCUMENTO") int numDoc, Model model) {
    //     Optional<AfiliadoRelacion> afiliadoRelacion = afiliadoRelacionRepository.darAfiliadoRelacion(numDoc);
    //     if (afiliadoRelacion.isPresent()) {
    //         model.addAttribute("afiliadoRelacion", afiliadoRelacion.get());
    //         return "afiliadoRelacionEditar";
    //     } else {
    //         return "redirect:/afiliadosRelaciones";
    //     }
    // }

    // @PostMapping("/afiliadosRelaciones/{NUMERO_DOCUMENTO}/edit/save")
    // public String afiliadoRelacionEditarGuardar(@PathVariable("NUMERO_DOCUMENTO") int numDoc, @ModelAttribute AfiliadoRelacion afiliadoRelacion) {
    //       afiliadoRelacionRepository.actualizarAfiliadoRelacion(numDoc, afiliadoRelacion.getTipoAfiliado().toString(), 
    //                                 afiliadoRelacion.getRelacionParentesco());
    //     return "redirect:/afiliadosRelaciones"; 
    // }

    // @GetMapping("/afiliadosRelaciones/{NUMERO_DOCUMENTO}/delete")
    // public String afiliadoEliminar(@PathVariable("NUMERO_DOCUMENTO") int numDoc) {
    //     afiliadoRelacionRepository.eliminarAfiliadoRelacion(numDoc);
    //     return "redirect:/afiliadosRelaciones";
    // }
}
