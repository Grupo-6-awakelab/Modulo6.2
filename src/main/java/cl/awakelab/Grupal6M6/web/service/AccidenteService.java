package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Accidente;
import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;

import java.util.List;
import java.util.Optional;

public interface AccidenteService {
    Optional<List<Accidente>> findAll();
    Optional<Accidente> findById(int id);
    Optional<Accidente> create(Accidente accidente);
    Optional<Accidente> update(Accidente accidente);
    void delete(int id);
}
