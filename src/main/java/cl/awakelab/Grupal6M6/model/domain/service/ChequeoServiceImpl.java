package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Chequeo;
import cl.awakelab.Grupal6M6.model.persistence.mapper.ChequeoMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.ChequeoRepository;
import cl.awakelab.Grupal6M6.web.service.ChequeoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChequeoServiceImpl implements ChequeoService {

    private final ChequeoMapper mapper;
    private final ChequeoRepository repository;

    public ChequeoServiceImpl(ChequeoMapper mapper, ChequeoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Optional<List<Chequeo>> findAll() {
        return Optional.of(mapper.toChequeos(repository.findAll()));
    }

    @Override
    public Optional<Chequeo> findById(int id) {
        return repository.findById(id).map(mapper::toChequeo);
    }

    @Override
    public Optional<Chequeo> create(Chequeo chequeo) {
        return Optional.of(
                mapper.toChequeo(
                repository.save(
                        mapper.toChequeo(chequeo)

                ))
        );
    }

    @Override
    public Optional<Chequeo> update(Chequeo chequeo) {
        return Optional.of(
                mapper.toChequeo(
                        repository.save(
                                mapper.toChequeo(chequeo)
                        )

        ));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
}
