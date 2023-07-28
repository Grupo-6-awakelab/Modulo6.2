package cl.awakelab.Grupal6M6.model.persistence.entity;


import cl.awakelab.Grupal6M6.model.domain.dto.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesional")
@NoArgsConstructor
public @Data class ProfesionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String run;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;
    @OneToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UsuarioEntity usuario;
}
