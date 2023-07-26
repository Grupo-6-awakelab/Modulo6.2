package cl.awakelab.Grupal6M6.model.domain.service;
import cl.awakelab.Grupal6M6.model.persistence.mapper.ClienteMapper;
import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.model.persistence.repository.ClienteRepository;
import cl.awakelab.Grupal6M6.web.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteServiceImpl(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Optional<List<Cliente>> findAll() {
        return Optional.of(mapper.toCliente(repository.findAll()));
    }

}
