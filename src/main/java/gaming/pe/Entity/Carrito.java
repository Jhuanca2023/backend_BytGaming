package gaming.pe.Entity;

import gaming.pe.Enums.CarritoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private CarritoStatus estado;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detalles;
}
