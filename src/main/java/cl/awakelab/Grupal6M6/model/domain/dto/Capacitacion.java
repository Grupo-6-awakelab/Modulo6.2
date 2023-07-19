package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
public @Data class Capacitacion {
    private int id;
    private String nombre;
    private String detalle;
    private Date fecha;
    private Time hora;
    private String lugar;
    private float duracion;
    private int cantidad;

    private Usuario usuario;



}
