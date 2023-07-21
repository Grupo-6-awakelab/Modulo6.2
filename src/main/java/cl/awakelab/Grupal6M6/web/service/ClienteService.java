package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.model.persistence.repository.ClienteRepository;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();

}
