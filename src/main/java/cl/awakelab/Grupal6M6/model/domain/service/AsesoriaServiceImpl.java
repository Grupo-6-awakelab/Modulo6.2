package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.model.persistence.mapper.AsesoriaMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.AsesoriaRepository;
import cl.awakelab.Grupal6M6.web.service.AsesoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesoriaServiceImpl implements AsesoriaService {
private final AsesoriaRepository repository;

private final AsesoriaMapper mapper;

    public AsesoriaServiceImpl(AsesoriaRepository repository, AsesoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Asesoria>> findAll() {
        return Optional.of(mapper.toAsesoria(repository.findAll()));
    }

    @Override
    public Optional<Asesoria> findById(int id) {
        return repository.findById(id).map(mapper::toAsesoria);
    }

    @Override
    public Optional<Asesoria> create(Asesoria asesoria) {
        return Optional.of(
                mapper.toAsesoria(
                        repository.save(
                                mapper.toAsesoria(asesoria)
                        )
                )
        );
    }

    @Override
    public Optional<Asesoria> update(Asesoria asesoria) {
        return Optional.of(
                mapper.toAsesoria(
                        repository.save(
                                mapper.toAsesoria(asesoria)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
