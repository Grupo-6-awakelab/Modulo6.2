package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.web.service.AsesoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/asesoria")
public class AsesoriaController {
    private final AsesoriaService asesoriaService;

    public AsesoriaController(AsesoriaService asesoriaService) {
        this.asesoriaService = asesoriaService;
    }

    @GetMapping
   public String asesoria(Model model){
       model.addAttribute("asesorias", asesoriaService.findAll());
    return "listarAsesorias";
    }

    @GetMapping("/crear")
    public String crear(){
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