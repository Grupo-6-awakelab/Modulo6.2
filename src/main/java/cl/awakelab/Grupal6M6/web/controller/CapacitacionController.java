package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {
    private final CapacitacionService capacitacionService;
    private final ClienteService clienteService;
    public CapacitacionController(CapacitacionService capacitacionService, ClienteService clienteService) {
        this.capacitacionService = capacitacionService;
        this.clienteService = clienteService;
    }


    @GetMapping
    public String capacitacion(Model model){
        model.addAttribute("capacitaciones",capacitacionService.findAll());

                return "listarCapacitacion";
    }

    @GetMapping("/crear")

     public String crear(Model model){
        model.addAttribute("isNew", true);
        model.addAttribute("clientes",clienteService.findAll());

        return "capacitacion";
    }
    @GetMapping("/editar/{capacitacionId}")

     public String editar(@PathVariable int capacitacionId, Model model){
        model.addAttribute("isNew", false);
        model.addAttribute("clientes",clienteService.findAll());
        model.addAttribute("capacitacion", capacitacionService.findById(capacitacionId));

        return "capacitacion";
    }



    @PostMapping("/crear")
    public String crear(@ModelAttribute Capacitacion capacitacion){
        Optional<Capacitacion> ok = capacitacionService.create(capacitacion);
        if (ok.isPresent()) {


            return "redirect:/capacitacion";
        } else {


            return "error";
        }

    }
    @PostMapping("/editar/{capacitacionId}")
    public String update(@ModelAttribute Capacitacion capacitacion,@PathVariable int capacitacionId){
        Optional<Capacitacion> ok = capacitacionService.update(capacitacion);
        if (ok.isPresent()) {


            return "redirect:/capacitacion";
        } else {


            return "redirect:/error";
        }

    }

    @GetMapping("/eliminar/{capacitacionId}")
    public String eliminarCapacitacion(@PathVariable int capacitacionId)    {
        capacitacionService.delete(capacitacionId);
        return "redirect:/capacitacion";
    }

}
