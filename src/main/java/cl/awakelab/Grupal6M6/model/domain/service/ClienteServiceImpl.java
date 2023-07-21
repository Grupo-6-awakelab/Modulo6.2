package cl.awakelab.Grupal6M6.model.domain.service;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.model.persistence.repository.ClienteRepository;
import cl.awakelab.Grupal6M6.web.service.ClienteService;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;
    private final ClienteService mapper;

    public ClienteServiceImpl(ClienteRepository repository, ClienteService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Cliente> findAll() {
        Cliente cl = new Cliente();
        return null;
    }
}
