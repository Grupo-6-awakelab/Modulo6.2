package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Administrativo;
import cl.awakelab.Grupal6M6.model.persistence.mapper.AdministrativoMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.AdministrativoRepository;
import cl.awakelab.Grupal6M6.web.service.AdministrativoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoServiceImpl implements AdministrativoService {
    private final AdministrativoRepository repository;
    private final AdministrativoMapper mapper;

    public AdministrativoServiceImpl(AdministrativoRepository repository, AdministrativoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Administrativo>> findAll() {
        return Optional.of(mapper.toAdministrativo(repository.findAll()));
    }

    @Override
    public Optional<Administrativo> findById(int id) {
        return repository.findById(id).map(mapper::toAdministrativo);
    }

    @Override
    public Optional<Administrativo> create(Administrativo administrativo) {

        return Optional.of(
                mapper.toAdministrativo(
                        repository.save(
                                mapper.toAdministrativo(administrativo)
                        )
                )
        );
    }

    @Override
    public Optional<Administrativo> update(Administrativo administrativo) {
        return Optional.of(
                mapper.toAdministrativo(
                        repository.save(
                                mapper.toAdministrativo(administrativo)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
