package cl.awakelab.Grupal6M6.model.domain.dto;

import cl.awakelab.Grupal6M6.model.persistence.entity.UsuarioEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Profesional {

    private int id;
    private String run;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;
    private Usuario usuario;

}
