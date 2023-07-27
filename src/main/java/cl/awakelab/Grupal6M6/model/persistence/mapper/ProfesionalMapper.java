package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;
import cl.awakelab.Grupal6M6.model.persistence.entity.ProfesionalEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "sprinng", uses = {UsuarioMapper.class})
public interface ProfesionalMapper {

    @Mappings({})
    Profesional toProfesional(ProfesionalEntity entity);
    List<Profesional> toProfesionals(List<ProfesionalEntity> entities);
    @InheritInverseConfiguration
    ProfesionalEntity toProfesional(Profesional profesional);
}
