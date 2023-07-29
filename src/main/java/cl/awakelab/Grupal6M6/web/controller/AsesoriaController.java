package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.web.service.AsesoriaService;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import cl.awakelab.Grupal6M6.web.service.ProfesionalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/asesoria")
public class AsesoriaController {
    private final AsesoriaService asesoriaService;
    private final ProfesionalService profesionalService;
    private final ClienteService clienteService;

    public AsesoriaController(AsesoriaService asesoriaService, ProfesionalService profesionalService, ClienteService clienteService) {
        this.asesoriaService = asesoriaService;
        this.profesionalService = profesionalService;
        this.clienteService = clienteService;
    }

    @GetMapping
   public String asesoria(Model model){
       model.addAttribute("asesorias", asesoriaService.findAll());
    return "listarAsesorias";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("profesionales",profesionalService.findAll());
        model.addAttribute("clientes",clienteService.findAll());
        return "asesoria";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute Asesoria asesoria){
        Optional<Asesoria> ok = asesoriaService.create(asesoria);
        if (ok.isPresent()){
            return "redirect:/asesoria";
        }else {
            return "redirect:/error";
        }
    }
}