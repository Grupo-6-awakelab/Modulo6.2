package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;
import cl.awakelab.Grupal6M6.model.persistence.mapper.ProfesionalMapper;

import java.util.List;
import java.util.Optional;

public interface ProfesionalService {

    Optional<List<Profesional>> findAll();
    Optional<Profesional> findById(int id);
    Optional<Profesional> create(Profesional user);
    Optional<Profesional> update(Profesional user);
    void delete(int id);
}
