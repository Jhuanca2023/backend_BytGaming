package gaming.pe.Entity;

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
private int IdProducto;

@Column(name = "Nombre_Pro", nullable = false)
private String nombre;

@Column(name = "Des_Pro", nullable = false)
private String descripcion;

@Column(name = "precio", nullable = false)
private Double precio;

@Column(name = "Stock", nullable = false)
private int stock;

@ManyToOne
@JoinColumn(name ="categoria_id",nullable = false)
private Categorias categoria;

}
