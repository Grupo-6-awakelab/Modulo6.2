package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Visita;
import cl.awakelab.Grupal6M6.model.persistence.entity.VisitaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "sprinng", uses = {ProfesionalMapper.class, ClienteMapper.class})

public interface VisitaMapper {

    @Mappings({})
    Visita toVisita(VisitaEntity entity);
    List<Visita> toListVisitas(List<VisitaEntity> visitas);
    @InheritInverseConfiguration
    VisitaEntity toVisita(Visita visita);
}
