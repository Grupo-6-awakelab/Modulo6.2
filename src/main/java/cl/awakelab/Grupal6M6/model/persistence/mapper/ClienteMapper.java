package cl.awakelab.Grupal6M6.model.persistence.mapper;
import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import cl.awakelab.Grupal6M6.model.persistence.entity.ClienteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface ClienteMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "rut", target = "rut"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "telefono", target = "telefono"),
            @Mapping(source = "afp", target = "afp"),
            @Mapping(source = "sisSalud", target = "sisSalud"),
            @Mapping(source = "direccion", target = "direccion"),
            @Mapping(source = "comuna", target = "comuna"),
            @Mapping(source = "edad", target = "edad"),
            @Mapping(source = "usuario", target = "usuario"),
    })
    Cliente toCliente(ClienteEntity cliente);
    List<Cliente> toCliente(List<ClienteEntity> clientes);
    @InheritInverseConfiguration
    ClienteEntity toCliente(Cliente cliente);
}

