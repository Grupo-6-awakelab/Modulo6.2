package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.ProfesionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionalRepository  extends JpaRepository<ProfesionalEntity, Integer>{
}
