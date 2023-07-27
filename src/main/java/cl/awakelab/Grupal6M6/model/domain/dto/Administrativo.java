package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Administrativo {
    private int id;
    private String run;
    private String nombre;
    private String apellido;
    private String correo;
    private String area;
    private Usuario usuario;
}
