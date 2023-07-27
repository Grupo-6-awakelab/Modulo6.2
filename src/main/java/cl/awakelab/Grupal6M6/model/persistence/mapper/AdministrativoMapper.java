package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Administrativo;
import cl.awakelab.Grupal6M6.model.persistence.entity.AdministrativoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface AdministrativoMapper {
    @Mappings({})
    Administrativo toAdministrativo(AdministrativoEntity Administrativo);

    List<Administrativo> toAdministrativo(List<AdministrativoEntity> administrativo);

    @InheritInverseConfiguration
    AdministrativoEntity toAdministrativo(Administrativo administrativo);

}
