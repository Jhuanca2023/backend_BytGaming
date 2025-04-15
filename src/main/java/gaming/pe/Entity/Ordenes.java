package gaming.pe.Entity;

import gaming.pe.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import proyect.pro.bygaming.Enum.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    private LocalDate fecha;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private OrderStatus estado;

    @OneToMany(mappedBy = "orden")
    private List<DetalleOrdenes> detalles;
}
