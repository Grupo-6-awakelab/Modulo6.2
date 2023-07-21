package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
}
