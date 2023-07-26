package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Optional<List<Cliente>> findAll();



}
