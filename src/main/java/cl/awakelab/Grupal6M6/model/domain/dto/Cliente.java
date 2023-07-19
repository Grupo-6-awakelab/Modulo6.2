package cl.awakelab.Grupal6M6.model.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Cliente {
    private int id;
    private String rut;
    private String correo;
    private String telefono;
    private String afp;
    private String direccion;
    private String comuna;
    private int edad;
    private Usuario usuario;


}
