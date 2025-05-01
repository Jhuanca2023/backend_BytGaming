package gaming.pe.Entity;

import java.util.Date;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_Comentarios_Producto")
public class ComentariosProducto {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int IdCome_Pro;

@ManyToOne
@JoinColumn(name="producto_id",nullable=false)
private Productos producto;

@ManyToOne
@JoinColumn(name="usuario_id",nullable=false)
private UserEntity usuario;

@Column(name = "Comentarios", nullable = false)
private String comentario;

@Column(name = "Puntuacion", nullable = false)
private int puntuacion;

@Column(name = "Fecha", nullable = false)
private Date fecha;


}
