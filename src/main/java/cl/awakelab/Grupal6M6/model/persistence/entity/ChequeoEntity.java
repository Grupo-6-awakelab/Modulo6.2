package cl.awakelab.Grupal6M6.model.persistence.entity;

import cl.awakelab.Grupal6M6.model.domain.dto.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chequeo")
@NoArgsConstructor
public @Data class ChequeoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id", insertable = false, updatable = false)
    VisitaEntity visita;
    private String detalle;
    @Enumerated(EnumType.STRING)
    EstadoEnum estado;
}
