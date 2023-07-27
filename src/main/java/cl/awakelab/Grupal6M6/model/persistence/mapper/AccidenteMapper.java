package cl.awakelab.Grupal6M6.model.persistence.mapper;


import cl.awakelab.Grupal6M6.model.domain.dto.Accidente;
import cl.awakelab.Grupal6M6.model.persistence.entity.AccidenteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface AccidenteMapper {

    @Mappings({})

    Accidente toAccidente(AccidenteEntity accidente);
    List<Accidente> toAccidente(List<AccidenteEntity> accidentes);
    @InheritInverseConfiguration
    AccidenteEntity toAccidente(Accidente accidente);
}
