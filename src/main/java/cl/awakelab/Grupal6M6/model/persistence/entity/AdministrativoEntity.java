package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="administrativo")
@NoArgsConstructor
public class AdministrativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String run;
    private String nombre;
    private String apellido;
    private String correo;
    private String area;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UsuarioEntity usuario;
}
