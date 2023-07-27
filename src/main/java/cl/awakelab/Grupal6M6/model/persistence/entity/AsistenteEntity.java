package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "asistente")
@NoArgsConstructor
public @Data class AsistenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capacitacion_id;
    private int usuario_id;
}
