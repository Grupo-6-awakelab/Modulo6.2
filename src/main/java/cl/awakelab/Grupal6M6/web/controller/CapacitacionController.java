package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
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
}
