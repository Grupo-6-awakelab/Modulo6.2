package cl.awakelab.Grupal6M6.model.persistence.entity;

import cl.awakelab.Grupal6M6.model.domain.dto.Cliente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "capacitacion")
@NoArgsConstructor
public @Data class CapacitacionEntity {
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
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;





}
