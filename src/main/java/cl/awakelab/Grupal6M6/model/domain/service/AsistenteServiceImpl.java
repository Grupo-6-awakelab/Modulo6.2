package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Asistente;
import cl.awakelab.Grupal6M6.model.persistence.mapper.AsistenteMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.AsistenteRepository;
import cl.awakelab.Grupal6M6.web.service.AsistenteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenteServiceImpl implements AsistenteService {
    private final AsistenteRepository repository;
    private final AsistenteMapper mapper;

    public AsistenteServiceImpl(AsistenteRepository repository, AsistenteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Asistente>> findAll() {
        return Optional.of(mapper.toAsistente(repository.findAll()));
    }

    @Override
    public Optional<Asistente> findById(int id) {
        return repository.findById(id).map(mapper::toAsistente);
    }

    @Override
    public Optional<Asistente> create(Asistente asistente) {
        return Optional.of(
                mapper.toAsistente(
                        repository.save(
                                mapper.toAsistente(asistente)
                        )
                )
        );
    }

    @Override
    public Optional<Asistente> update(Asistente asistente) {
        return Optional.of(
                mapper.toAsistente(
                        repository.save(
                                mapper.toAsistente(asistente)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
