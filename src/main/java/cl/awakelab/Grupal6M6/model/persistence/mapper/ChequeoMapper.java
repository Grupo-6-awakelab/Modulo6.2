package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Chequeo;
import cl.awakelab.Grupal6M6.model.domain.dto.Visita;
import cl.awakelab.Grupal6M6.model.persistence.entity.ChequeoEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "sprinng", uses = {Visita.class})
public interface ChequeoMapper {
    @Mappings({})
    Chequeo toChequeo(ChequeoEntity entity);
    List<Chequeo> toChequeos(List<ChequeoEntity> chequeos);
    @InheritConfiguration
    ChequeoEntity toChequeo(Chequeo chequeo);
}
