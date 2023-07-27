package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Accidente;
import cl.awakelab.Grupal6M6.model.persistence.mapper.AccidenteMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.AccidenteRepository;
import cl.awakelab.Grupal6M6.web.service.AccidenteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccidenteServiceImpl implements AccidenteService {

    private final AccidenteMapper mapper;
    private final AccidenteRepository repository;

    public AccidenteServiceImpl(AccidenteMapper mapper, AccidenteRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<List<Accidente>> findAll() {
        return Optional.of(mapper.toAccidente(repository.findAll()));
    }

    @Override
    public Optional<Accidente> findById(int id) {
        return repository.findById(id).map(mapper::toAccidente);

    }

    @Override
    public Optional<Accidente> create(Accidente accidente) {
        return Optional.of(
                mapper.toAccidente(
                        repository.save(
                                mapper.toAccidente(accidente)
                        )
                )
        );
    }

    @Override
    public Optional<Accidente> update(Accidente accidente) {
        return Optional.of(
                mapper.toAccidente(
                        repository.save(
                                mapper.toAccidente(accidente)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
