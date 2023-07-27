package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
public @Data class Visita {
    private int id;
    private Cliente cliente;
    private Date fecha;
    private Time hora;
    private String lugar;
    private int realizado;
    private String detalle;
    Profesional professional;

}
