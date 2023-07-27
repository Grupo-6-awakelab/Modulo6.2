package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Asesoria {
    private int id;
    private String nombre;
    private String detalle;
    private Profesional profesional;
    private Cliente cliente;
}
