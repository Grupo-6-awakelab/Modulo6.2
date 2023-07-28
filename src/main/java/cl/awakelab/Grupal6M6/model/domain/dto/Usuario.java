package cl.awakelab.Grupal6M6.model.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Usuario {
    private int id;
    private String role;
    private String username;
    private String password;
}
