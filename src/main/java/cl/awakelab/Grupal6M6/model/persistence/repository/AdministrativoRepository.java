package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.AdministrativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativoRepository extends JpaRepository<AdministrativoEntity, Integer> {
}
