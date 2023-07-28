package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;
import cl.awakelab.Grupal6M6.model.persistence.mapper.CapacitacionMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.CapacitacionRepository;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {
    private final CapacitacionRepository repository;
    private final CapacitacionMapper mapper;

    public CapacitacionServiceImpl(CapacitacionRepository repository, CapacitacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Capacitacion>> findAll() {
        return Optional.of(mapper.toCapacitacion(repository.findAll()));
    }

    @Override
    public Optional<Capacitacion> findById(int id) {
        return repository.findById(id).map(mapper::toCapacitacionDto);
    }

    @Override
    public Optional<Capacitacion> create(Capacitacion capacitacion) {
        return Optional.of(
                mapper.toCapacitacionDto(
                        repository.save(
                                mapper.toCapacitacionEntity(capacitacion)
                                )
                        )
                );
    }

    @Override
    public Optional<Capacitacion> update(Capacitacion capacitacion) {
        return Optional.of(
                mapper.toCapacitacionDto(
                        repository.save(
                                mapper.toCapacitacionEntity(capacitacion)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
