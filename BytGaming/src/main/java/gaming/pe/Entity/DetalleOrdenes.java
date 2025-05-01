package gaming.pe.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="tbl_DetalleOrden")
public class DetalleOrdenes {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idDetalleOrden;

@ManyToOne
@JoinColumn(name = "orden_id", nullable=false)
private Ordenes orden;

@ManyToOne
@JoinColumn(name = "producto_id", nullable=false)
private Productos producto;

@Column(name = "Cantidad", nullable = false)
private int cantidad;

@Column(name = "Precio_Uni", nullable = false)
private Double precio_unitario;

}
