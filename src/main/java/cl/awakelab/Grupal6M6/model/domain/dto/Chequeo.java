package cl.awakelab.Grupal6M6.model.domain.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Chequeo {
    private int id;
    Visita visita;
    private String detalle;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
}
