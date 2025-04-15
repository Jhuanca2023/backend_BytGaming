package gaming.pe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ComentariosProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    private String comentario;
    private int puntuacion;
    private LocalDate fecha;
}
