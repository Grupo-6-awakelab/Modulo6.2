package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Asistente;
import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface CapacitacionService {
    Optional<List<Capacitacion>> findAll();
    Optional<Capacitacion> findById(int id);
    Optional<Capacitacion> create(Capacitacion capacitacion);
    Optional<Capacitacion> update(Capacitacion capacitacion);
    void delete(int id);

}
