package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asesoria")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AsesoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String detalle;
    @OneToOne
    @JoinColumn(name = "profesional_id")
    private ProfesionalEntity profesional;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

}
