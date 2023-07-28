package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {
    private final CapacitacionService capacitacionService;

    public CapacitacionController(CapacitacionService capacitacionService) {
        this.capacitacionService = capacitacionService;
    }


    @GetMapping
    public String capacitacion(Model model){
        model.addAttribute("capacitaciones",capacitacionService.findAll());

                return "listarCapacitacion";
    }

    @GetMapping("/crear")
     public String crear(){

        return "capacitacion";
    }


    @PostMapping("/crear")
    public String crear(@ModelAttribute Capacitacion capacitacion){
        Optional<Capacitacion> ok = capacitacionService.create(capacitacion);
        if (ok.isPresent()) {


            return "redirect:/capacitacion";
        } else {


            return "redirect:/error";
        }

    }
}
