package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import cl.awakelab.Grupal6M6.model.persistence.mapper.UsuarioMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.UsuarioRepository;
import cl.awakelab.Grupal6M6.web.service.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }
}
