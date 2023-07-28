package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Profesional;
import cl.awakelab.Grupal6M6.model.persistence.entity.ProfesionalEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface ProfesionalMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "run", target = "run"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "cargo", target = "cargo"),
            @Mapping(source = "usuario.id", target = "usuarioId")

    })

    Profesional toProfesional(ProfesionalEntity entity);
    List<Profesional> toProfesionals(List<ProfesionalEntity> entities);
    @InheritInverseConfiguration
    ProfesionalEntity toProfesional(Profesional profesional);
}
