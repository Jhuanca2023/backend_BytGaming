package gaming.pe.Entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;


    @OneToMany(mappedBy = "producto")
    private List<ComentariosProducto> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCarrito> detallesCarrito;

    @OneToMany(mappedBy = "producto")
    private List<DetalleOrdenes> detallesOrden;

}
