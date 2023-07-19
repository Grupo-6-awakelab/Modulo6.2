package cl.awakelab.Grupal6M6.model.persistence.entity;

import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "capacitacion")

public @Data class Capacitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String detalle;
    private Date fecha;
    private Time hora;
    private String lugar;
    private float duracion;
    private int cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", insertable = false, updatable = false)
    private Usuario usuario;

}
