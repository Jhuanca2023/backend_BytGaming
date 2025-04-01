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
private Users usuario;

@Column(name = "Comentarios", nullable = false)
private String comentario;

@Column(name = "Puntuacion", nullable = false)
private int puntuacion;

@Column(name = "Fecha", nullable = false)
private Date fecha;

public ComentariosProducto() {
	super();
}

public ComentariosProducto(int idCome_Pro, Productos producto, Users usuario, String comentario, int puntuacion,
		Date fecha) {
	super();
	IdCome_Pro = idCome_Pro;
	this.producto = producto;
	this.usuario = usuario;
	this.comentario = comentario;
	this.puntuacion = puntuacion;
	this.fecha = fecha;
}

public int getIdCome_Pro() {
	return IdCome_Pro;
}

public void setIdCome_Pro(int idCome_Pro) {
	IdCome_Pro = idCome_Pro;
}

public Productos getProductos() {
	return producto;
}

public void setProductos(Productos productos) {
	this.producto = productos;
}

public Users getUsuario() {
	return usuario;
}

public void setUsuario(Users usuario) {
	this.usuario = usuario;
}

public String getComentario() {
	return comentario;
}

public void setComentario(String comentario) {
	this.comentario = comentario;
}

public int getPuntuacion() {
	return puntuacion;
}

public void setPuntuacion(int puntuacion) {
	this.puntuacion = puntuacion;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

}
