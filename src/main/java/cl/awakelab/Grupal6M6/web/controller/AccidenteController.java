package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Accidente;
import cl.awakelab.Grupal6M6.web.service.AccidenteService;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/accidente")
public class AccidenteController {
    private final AccidenteService accidenteService;
    private final ClienteService clienteService;

    public AccidenteController(AccidenteService accidenteService, ClienteService clienteService) {
        this.accidenteService = accidenteService;
        this.clienteService = clienteService;
    }


    @GetMapping
    public String accidente(Model model){
        model.addAttribute("accidentes",accidenteService.findAll());

                return "listarAccidente";
    }

    @GetMapping("/crear")

     public String crear(Model model){
        model.addAttribute("clientes",clienteService.findAll());

        return "accidente";
    }


    @PostMapping("/crear")
    public String crear(@ModelAttribute Accidente accidente){
        Optional<Accidente> ok = accidenteService.create(accidente);
        if (ok.isPresent()) {


            return "redirect:/accidente";
        } else {


            return "redirect:/error";
        }

    }
}
