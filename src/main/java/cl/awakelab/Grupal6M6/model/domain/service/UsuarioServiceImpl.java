package cl.awakelab.Grupal6M6.model.domain.service;
import org.springframework.stereotype.Service;
import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import cl.awakelab.Grupal6M6.model.persistence.mapper.UsuarioMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.UsuarioRepository;
import cl.awakelab.Grupal6M6.web.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Optional<List<Usuario>> findAll() {
        return Optional.of(mapper.toUsuarios(repository.findAll()));
    }

    @Override
    public Optional<Usuario> findById(int id) {
        return repository.findById(id).map(mapper::toUsuario);

    }

    @Override
    public Optional<Usuario> create(Usuario usuario) {
        return Optional.of(
                mapper.toUsuario(
                        repository.save(
                         mapper.toUsuario(usuario)
                        )

        ));
    }

    @Override
    public Optional<Usuario> update(Usuario usuario) {
        return Optional.of(
                mapper.toUsuario(
                        repository.save(
                                mapper.toUsuario(usuario)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }


}
