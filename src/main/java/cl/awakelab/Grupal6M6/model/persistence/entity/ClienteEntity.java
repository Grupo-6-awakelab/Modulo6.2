package cl.awakelab.Grupal6M6.model.persistence.entity;

import cl.awakelab.Grupal6M6.model.domain.dto.SissaludEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "cliente")
@NoArgsConstructor
public @Data class ClienteEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String afp;
    @Column(name = "sistema_salud")
    @Enumerated(EnumType.STRING)
    private SissaludEnum sisSalud;
    private String direccion;
    private String comuna;
    private int edad;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UsuarioEntity usuario;



}
