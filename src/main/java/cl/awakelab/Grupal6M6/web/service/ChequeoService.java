package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Accidente;
import cl.awakelab.Grupal6M6.model.domain.dto.Chequeo;
import cl.awakelab.Grupal6M6.model.persistence.entity.ChequeoEntity;

import java.util.List;
import java.util.Optional;

public interface ChequeoService {
    Optional<List<Chequeo>> findAll();
    Optional<Chequeo> findById(int id);
    Optional<Chequeo> create(Chequeo chequeo);
    Optional<Chequeo> update(Chequeo chequeo);
    void delete(int id);
}
