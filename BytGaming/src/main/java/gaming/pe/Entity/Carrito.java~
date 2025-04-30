package gaming.pe.Entity;

import java.util.Date;
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

@Entity
@Table (name ="tbl_Carrito")
public class Carrito {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int IdCarrito;

 @ManyToOne
 @JoinColumn(name ="usuario_id",nullable=false)
 private Users usuario;
 
 @Column(name = "Fecha_Creacion", nullable = false)
 private Date fechaCreacion;

@OneToMany(mappedBy="carrito")
private List<DetalleCarrito> detalleCarrito;

public Carrito() {
	super();
}

public Carrito(int idCarrito, Users usuario, Date fechaCreacion, List<DetalleCarrito> detalleCarrito) {
	super();
	IdCarrito = idCarrito;
	this.usuario = usuario;
	this.fechaCreacion = fechaCreacion;
	this.detalleCarrito = detalleCarrito;
}

public int getIdCarrito() {
	return IdCarrito;
}

public void setIdCarrito(int idCarrito) {
	IdCarrito = idCarrito;
}

public Users getUsuario() {
	return usuario;
}

public void setUsuario(Users usuario) {
	this.usuario = usuario;
}

public Date getFechaCreacion() {
	return fechaCreacion;
}

public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
}

public List<DetalleCarrito> getDetalleCarrito() {
	return detalleCarrito;
}

public void setDetalleCarrito(List<DetalleCarrito> detalleCarrito) {
	this.detalleCarrito = detalleCarrito;
}

}
