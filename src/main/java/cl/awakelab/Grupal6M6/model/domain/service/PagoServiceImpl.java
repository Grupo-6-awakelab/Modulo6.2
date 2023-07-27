package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Pago;
import cl.awakelab.Grupal6M6.model.persistence.mapper.PagoMapper;
import cl.awakelab.Grupal6M6.model.persistence.repository.PagoRepository;
import cl.awakelab.Grupal6M6.web.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;
    private final PagoMapper mapper;

    public PagoServiceImpl(PagoRepository repository, PagoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Pago>> findAll() {
        return Optional.of(mapper.toPagos(repository.findAll()));
    }

    @Override
    public Optional<Pago> findById(int id) {
        return repository.findById(id).map(mapper::toPago);
    }

    @Override
    public Optional<Pago> create(Pago pago) {
        return Optional.of(
                mapper.toPago(
                        repository.save(
                                mapper.toPago(pago)
                        )
                )
        );
    }

    @Override
    public Optional<Pago> update(Pago pago) {
        return Optional.of(
                mapper.toPago(
                        repository.save(
                                mapper.toPago(pago)
                        )
                )
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
