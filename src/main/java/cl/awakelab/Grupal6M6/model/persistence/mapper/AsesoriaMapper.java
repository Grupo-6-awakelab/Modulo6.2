package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.model.persistence.entity.AsesoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface AsesoriaMapper {
    @Mappings({})
    Asesoria toAsesoria(AsesoriaEntity asesoria);

    List<Asesoria> toAsesoria(List<AsesoriaEntity> asesoria);

    @InheritInverseConfiguration
    AsesoriaEntity toAsesoria(Asesoria asesoria);
}
