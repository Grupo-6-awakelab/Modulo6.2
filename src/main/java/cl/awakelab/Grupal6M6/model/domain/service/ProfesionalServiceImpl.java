package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;
import cl.awakelab.Grupal6M6.model.persistence.mapper.ProfesionalMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.ProfesionalRepository;
import cl.awakelab.Grupal6M6.web.service.ProfesionalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfesionalServiceImpl implements ProfesionalService {
private final ProfesionalRepository repository;
private final ProfesionalMapper mapper;

    public ProfesionalServiceImpl(ProfesionalRepository repository, ProfesionalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Profesional>> findAll() {
        return Optional.of(mapper.toProfesionals(repository.findAll()));
}
    @Override
    public Optional<Profesional> findById(int id) {
        return repository.findById(id).map(mapper::toProfesional);
    }

    @Override
    public Optional<Profesional> create(Profesional profesional) {
        return Optional.of(
                mapper.toProfesional(
                        repository.save(
                                mapper.toProfesional(profesional)
                        )
                )
        );
    }

    @Override
    public Optional<Profesional> update(Profesional profesional) {
        return Optional.of(
                mapper.toProfesional(
                        repository.save(
                                mapper.toProfesional(profesional)
                        )
                )
        );
    }

    @Override
    public void  delete(int id) {
        repository.deleteById(id);
    }
}
