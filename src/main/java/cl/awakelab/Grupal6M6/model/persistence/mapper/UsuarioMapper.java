package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import cl.awakelab.Grupal6M6.model.persistence.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
    })
    Usuario toUser(UsuarioEntity usuario);
    List<Usuario> toUsuarios(List<UsuarioEntity> usuarios);
    @InheritInverseConfiguration
    UsuarioEntity toUsuario(Usuario user);
}
