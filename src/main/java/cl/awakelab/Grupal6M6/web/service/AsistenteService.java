package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.model.domain.dto.Asistente;

import java.util.List;
import java.util.Optional;

public interface AsistenteService {
    Optional<List<Asistente>> findAll();
    Optional<Asistente> findById(int id);
    Optional<Asistente> create(Asistente asistente);
    Optional<Asistente> update(Asistente Asistente);
    void delete(int id);
}