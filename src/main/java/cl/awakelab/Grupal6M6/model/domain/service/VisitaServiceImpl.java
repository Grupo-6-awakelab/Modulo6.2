package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Visita;
import cl.awakelab.Grupal6M6.model.persistence.mapper.VisitaMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.VisitaRepository;
import cl.awakelab.Grupal6M6.web.service.VisitaService;

import java.util.List;
import java.util.Optional;

public class VisitaServiceImpl implements VisitaService {

    private final VisitaMapper mapper;
    private final VisitaRepository repository;

    public VisitaServiceImpl(VisitaMapper mapper, VisitaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<List<Visita>> findAll() {
        return Optional.of(mapper.toListVisitas(repository.findAll()));
    }

    @Override
    public Optional<Visita> findById(int id) {
        return repository.findById(id).map(mapper::toVisita);
    }

    @Override
    public Optional<Visita> create(Visita visita) {
        return Optional.of(
                mapper.toVisita(
                        repository.save(
                                mapper.toVisita(visita)
                        )
                ));
    }

    @Override
    public Optional<Visita> update(Visita visita) {
        return Optional.of(mapper.toVisita(
                repository.save(
                        mapper.toVisita(visita)
                )
        ));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
