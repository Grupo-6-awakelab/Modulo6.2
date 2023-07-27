package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "visita")
@NoArgsConstructor
public @Data class VisitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", insertable = false, updatable = false)
    ClienteEntity cliente;
    private Date fecha;
    private Time hora;
    private String lugar;
    private int realizado;
    private String detalle;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="profesional_id", insertable = false, updatable = false)
    ProfesionalEntity profesional;

}
