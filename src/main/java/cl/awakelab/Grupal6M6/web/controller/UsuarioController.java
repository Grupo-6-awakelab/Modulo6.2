package cl.awakelab.Grupal6M6.web.controller;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import cl.awakelab.Grupal6M6.web.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public String usuario(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
    return "listarUsuarios";
    }

    @GetMapping("/crear")
    public String crear(){
        return "usuario";
    }

    @PostMapping("/crear")
    public String crear(@ModelAttribute Usuario usuario){
        Optional<Usuario> ok = usuarioService.create(usuario);
        if (ok.isPresent()){
            return "redirect:/usuario";
        }else {
            return "redirect:/error";
        }
    }
}