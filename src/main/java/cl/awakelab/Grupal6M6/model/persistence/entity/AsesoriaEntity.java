package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asesoria")
@NoArgsConstructor
public @Data class AsesoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String detalle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id", insertable = false, updatable = false)
    private ProfesionalEntity profesional;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", insertable = false, updatable = false)
    private ClienteEntity cliente;

}
