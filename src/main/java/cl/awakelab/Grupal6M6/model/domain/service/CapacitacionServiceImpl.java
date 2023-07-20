package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;
import cl.awakelab.Grupal6M6.model.persistence.mapper.CapacitacionMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.CapacitacionRepository;
import cl.awakelab.Grupal6M6.web.service.CapacitacionService;

import java.util.List;

public class CapacitacionServiceImpl implements CapacitacionService {
    private final CapacitacionRepository repository;
    private final CapacitacionMapper mapper;

    public CapacitacionServiceImpl(CapacitacionRepository repository, CapacitacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<Capacitacion> findAll() {
    Capacitacion c = new Capacitacion();
        return this.mapper.toCapacitacion(repository.findAll());
    }


}
