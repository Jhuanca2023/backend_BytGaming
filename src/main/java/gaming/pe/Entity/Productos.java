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


@OneToMany(mappedBy ="producto")
private List<DetalleOrdenes> detalleOrdenes;

@OneToMany(mappedBy ="producto")
private List<DetalleCarrito> detalleCarrito;

@OneToMany(mappedBy ="producto")
private List<ComentariosProducto> comentariosProducto;

public Productos() {
	super();
}

public Productos(int idProducto, String nombre, String descripcion, Double precio, int stock, Categorias categoria,
		List<DetalleOrdenes> detalleOrdenes, List<DetalleCarrito> detalleCarrito,
		List<ComentariosProducto> comentariosProducto) {
	super();
	IdProducto = idProducto;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
	this.stock = stock;
	this.categoria = categoria;
	this.detalleOrdenes = detalleOrdenes;
	this.detalleCarrito = detalleCarrito;
	this.comentariosProducto = comentariosProducto;
}

public int getIdProducto() {
	return IdProducto;
}

public void setIdProducto(int idProducto) {
	IdProducto = idProducto;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Double getPrecio() {
	return precio;
}

public void setPrecio(Double precio) {
	this.precio = precio;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public Categorias getCategoria() {
	return categoria;
}

public void setCategoria(Categorias categoria) {
	this.categoria = categoria;
}

public List<DetalleOrdenes> getDetalleOrdenes() {
	return detalleOrdenes;
}

public void setDetalleOrdenes(List<DetalleOrdenes> detalleOrdenes) {
	this.detalleOrdenes = detalleOrdenes;
}

public List<DetalleCarrito> getDetalleCarrito() {
	return detalleCarrito;
}

public void setDetalleCarrito(List<DetalleCarrito> detalleCarrito) {
	this.detalleCarrito = detalleCarrito;
}

public List<ComentariosProducto> getComentariosProducto() {
	return comentariosProducto;
}

public void setComentariosProducto(List<ComentariosProducto> comentariosProducto) {
	this.comentariosProducto = comentariosProducto;
}

}
