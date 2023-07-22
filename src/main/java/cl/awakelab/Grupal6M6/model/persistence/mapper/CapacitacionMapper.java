package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Capacitacion;

import cl.awakelab.Grupal6M6.model.persistence.entity.CapacitacionEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface CapacitacionMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "detalle", target = "detalle"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "hora", target = "hora"),
            @Mapping(source = "lugar", target = "lugar"),
            @Mapping(source = "duracion", target = "duracion"),
            @Mapping(source = "cantidad", target = "cantidad"),
            @Mapping(source = "cliente", target = "cliente"),

    })
    Capacitacion toCapacitacion(CapacitacionEntity capacitacion);

    List<Capacitacion> toCapacitacion(List<CapacitacionEntity> capacitaciones);

    @InheritInverseConfiguration
    CapacitacionEntity toCapacitacion(Capacitacion capacitacion);

}
