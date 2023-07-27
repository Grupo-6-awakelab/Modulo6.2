package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface CapacitacionService {
    List<Capacitacion> findAll();
    Optional<Capacitacion> findById(int id);

}
