package gaming.pe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleOrdenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Ordenes orden;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto;

    private int cantidad;
    private BigDecimal precioUnitario;
}
