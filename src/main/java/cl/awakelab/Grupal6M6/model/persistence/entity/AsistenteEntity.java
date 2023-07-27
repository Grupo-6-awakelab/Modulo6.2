package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "asistente")
@NoArgsConstructor
public class AsistenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int capacitacion_id;
    private int usuario_id;
}
