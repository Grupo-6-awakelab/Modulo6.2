package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
}
