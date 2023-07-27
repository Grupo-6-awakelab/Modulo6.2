package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;

import java.util.List;
import java.util.Optional;

public interface AsesoriaService {
    Optional<List<Asesoria>> findAll();
    Optional<Asesoria> findById(int id);
    Optional<Asesoria> create(Asesoria asesoria);
    Optional<Asesoria> update(Asesoria asesoria);
    void delete(int id);
}
