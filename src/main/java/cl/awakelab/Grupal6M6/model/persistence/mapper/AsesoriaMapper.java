package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Asesoria;
import cl.awakelab.Grupal6M6.model.persistence.entity.AsesoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class,ProfesionalMapper.class})
public interface AsesoriaMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "detalle", target = "detalle"),
            @Mapping(source = "cliente.id", target = "clienteId"),
            @Mapping(source = "profesional.id", target = "profesionalId"),

    })


    Asesoria toAsesoriaDTO(AsesoriaEntity asesoria);

    List<Asesoria> toAsesorias(List<AsesoriaEntity> asesorias);

    @InheritInverseConfiguration
    AsesoriaEntity toAsesoriaEntity(Asesoria asesoria);
}
