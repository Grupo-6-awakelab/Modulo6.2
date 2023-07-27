package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
public @Data class Pago {
    private int id;
    private int cliente_id;
    private float monto;
    private Date fecha_pago;
}
