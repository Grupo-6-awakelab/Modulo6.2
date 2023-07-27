package cl.awakelab.Grupal6M6.model.persistence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name ="pago")
@NoArgsConstructor
public class PagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cliente_id;
    private float monto;
    private Date fecha_pago;
}
