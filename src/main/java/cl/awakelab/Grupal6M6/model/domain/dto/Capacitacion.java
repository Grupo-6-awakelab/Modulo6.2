package cl.awakelab.Grupal6M6.model.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@NoArgsConstructor
public @Data class Capacitacion {
    private int id;
    private String nombre;
    private String detalle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private Time hora;
    private String lugar;
    private float duracion;
    private int cantidad;
    @JsonIgnore
    private Cliente cliente;
    @JsonProperty("clienteId")
    private int clienteId;

}
