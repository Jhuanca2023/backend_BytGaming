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
@Table(name ="tbl_Deta_Carrito")
public class DetalleCarrito {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int IdDetalleCarrito;

@ManyToOne
@JoinColumn(name="carrito_id", nullable=false)
private Carrito carrito;

@ManyToOne
@JoinColumn(name="producto_id",nullable=false)
private  Productos producto;


@Column(name = "Cantidad", nullable = false)
private int cantidad;

@Column(name = "Precio_Uni", nullable = false)
private Double precio_unitario;

public DetalleCarrito() {
	super();
}

public DetalleCarrito(int idDetalleCarrito, Carrito carrito, Productos producto, int cantidad, Double precio_unitario) {
	super();
	IdDetalleCarrito = idDetalleCarrito;
	this.carrito = carrito;
	this.producto = producto;
	this.cantidad = cantidad;
	this.precio_unitario = precio_unitario;
}

public int getIdDetalleCarrito() {
	return IdDetalleCarrito;
}

public void setIdDetalleCarrito(int idDetalleCarrito) {
	IdDetalleCarrito = idDetalleCarrito;
}

public Carrito getCarrito() {
	return carrito;
}

public void setCarrito(Carrito carrito) {
	this.carrito = carrito;
}

public Productos getProducto() {
	return producto;
}

public void setProducto(Productos producto) {
	this.producto = producto;
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
