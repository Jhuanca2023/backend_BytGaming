package gaming.pe.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Categoria")
public class Categorias {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCategoria;

@Column(name = "Nombre_Cate", nullable = false)
private String nombre;

@Column(name = "Des_Cate", nullable = false)
private String descripcion;

@OneToMany(mappedBy="categoria")
private List<Productos> productos;

}
