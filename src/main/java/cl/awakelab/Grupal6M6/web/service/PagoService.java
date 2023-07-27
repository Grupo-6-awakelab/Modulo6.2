package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Administrativo;
import cl.awakelab.Grupal6M6.model.domain.dto.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {
    Optional<List<Pago>> findAll();
    Optional<Pago> findById(int id);
    Optional<Pago> create(Pago pago);
    Optional<Pago> update(Pago pago);
    void delete(int id);
}
