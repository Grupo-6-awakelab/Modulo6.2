package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;
import cl.awakelab.Grupal6M6.model.domain.dto.Visita;

import java.util.List;
import java.util.Optional;

public interface VisitaService {
    Optional<List<Visita>> findAll();
    Optional<Visita> findById(int id);
    Optional<Visita> create(Visita visita);
    Optional<Visita> update(Visita visita);
    void delete(int id);
}
