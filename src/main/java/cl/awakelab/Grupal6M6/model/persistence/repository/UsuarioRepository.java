package cl.awakelab.Grupal6M6.model.persistence.repository;

import cl.awakelab.Grupal6M6.model.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    UsuarioEntity findByUsername(String username);

}
