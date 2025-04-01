package gaming.pe.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


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

public DetalleOrdenes() {
	super();
}

public DetalleOrdenes(int idDetalleOrden, Ordenes orden, Productos producto, int cantidad, Double precio_unitario) {
	super();
	this.idDetalleOrden = idDetalleOrden;
	this.orden = orden;
	this.producto = producto;
	this.cantidad = cantidad;
	this.precio_unitario = precio_unitario;
}

public int getIdDetalleOrden() {
	return idDetalleOrden;
}

public void setIdDetalleOrden(int idDetalleOrden) {
	this.idDetalleOrden = idDetalleOrden;
}

public Ordenes getOrdenes() {
	return orden;
}

public void setOrdenes(Ordenes ordenes) {
	this.orden = ordenes;
}

public Productos getProductos() {
	return producto;
}

public void setProductos(Productos productos) {
	this.producto = productos;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public Double getPrecio_unitario() {
	return precio_unitario;
}

public void setPrecio_unitario(Double precio_unitario) {
	this.precio_unitario = precio_unitario;
}

}
