package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.ChequeoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChequeoRepository extends JpaRepository<ChequeoEntity, Integer> {
}
