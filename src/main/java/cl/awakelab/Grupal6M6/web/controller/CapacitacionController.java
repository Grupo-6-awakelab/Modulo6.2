package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CapacitacionController {
    private final ClienteService service;

    public CapacitacionController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String capacitacion(Model model){
        model.addAttribute("clientes",service.findAll());
        return "index";
    }
}