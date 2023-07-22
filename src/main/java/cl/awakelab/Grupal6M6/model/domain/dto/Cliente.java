package cl.awakelab.Grupal6M6.model.domain.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Cliente {
    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String afp;
    @Enumerated(EnumType.STRING)
    private SissaludEnum sisSalud;
    private String direccion;
    private String comuna;
    private int edad;
    private Usuario usuario;


}
