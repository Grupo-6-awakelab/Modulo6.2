package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Administrativo;

import java.util.List;
import java.util.Optional;

public interface AdministrativoService {
    Optional<List<Administrativo>> findAll();
    Optional<Administrativo> findById(int id);
    Optional<Administrativo> create(Administrativo administrativo);
    Optional<Administrativo> update(Administrativo administrativo);
    void delete(int id);
}
