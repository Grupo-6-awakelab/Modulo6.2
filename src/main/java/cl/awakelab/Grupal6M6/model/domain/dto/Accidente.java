package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public @Data class Accidente {

    private int id;
    private Cliente cliente;
    private Date fechaAccidente;
    private String detalle;
}
