package gaming.pe.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

public Categorias() {
	super();
}

public Categorias(int idCategoria, String nombre, String descripcion, List<Productos> productos) {
	super();
	this.idCategoria = idCategoria;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.productos = productos;
}

public int getIdCategoria() {
	return idCategoria;
}

public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
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

public List<Productos> getProductos() {
	return productos;
}

public void setProductos(List<Productos> productos) {
	this.productos = productos;
}

}
