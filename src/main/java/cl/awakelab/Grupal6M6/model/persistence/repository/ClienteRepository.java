package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
