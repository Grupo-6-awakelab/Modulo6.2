package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
}
