package cl.awakelab.Grupal6M6.model.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Asesoria {
    private int id;
    private String nombre;
    private String detalle;
    @JsonIgnore
    private Cliente cliente;
    @JsonIgnore
    private Profesional profesional;
    @JsonProperty("profesionalId")
    private int profesionalId;
    @JsonProperty("clienteId")
    private int clienteId;
}
