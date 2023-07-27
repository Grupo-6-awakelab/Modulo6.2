package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Asistente;
import cl.awakelab.Grupal6M6.model.persistence.entity.AsistenteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses ={UsuarioMapper.class, CapacitacionMapper.class})
public interface AsistenteMapper {
    @Mappings({})
    Asistente toAsistente (AsistenteEntity asistente);

    List<Asistente> toAsistente(List<AsistenteEntity> asistente);

    @InheritInverseConfiguration
    AsistenteEntity toAsistente(Asistente asistente);
}
