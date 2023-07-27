package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import cl.awakelab.Grupal6M6.model.domain.dto.Visita;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<List<Usuario>> findAll();
    Optional<Usuario> findById(int id);
    Optional<Usuario> create(Usuario usuario);
    Optional<Usuario> update(Usuario usuario);
    void delete(int id);

}