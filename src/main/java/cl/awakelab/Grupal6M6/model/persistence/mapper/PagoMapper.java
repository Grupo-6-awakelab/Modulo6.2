package cl.awakelab.Grupal6M6.model.persistence.mapper;

import cl.awakelab.Grupal6M6.model.domain.dto.Pago;
import cl.awakelab.Grupal6M6.model.persistence.entity.PagoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface PagoMapper {
@Mappings({})
    Pago toPago(PagoEntity pago);
    List<Pago> toPagos(List<PagoEntity> pagos);
    @InheritInverseConfiguration
    PagoEntity toPago(Pago pago);
}
