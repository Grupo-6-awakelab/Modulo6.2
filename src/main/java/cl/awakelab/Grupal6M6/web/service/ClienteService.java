package cl.awakelab.Grupal6M6.web.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
  Optional <List<Cliente>> findAll();
    Optional<Cliente> findById(int id);
    Optional<Cliente> create(Cliente cliente);
    Optional<Cliente> update(Cliente cliente);
    void delete(int id);


}
