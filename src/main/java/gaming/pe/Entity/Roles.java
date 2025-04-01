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
@Table(name ="tbl_roles")
public class Roles {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int IdRol;
@Column(name = "Nombre_Rol", nullable = false)
private String nombre;

@Column(name = "Des_Rol", nullable = false)
private String descripcion;

@OneToMany(mappedBy ="roles")
private List<Users> usuario;

public Roles() {
	super();
}

public Roles(int idRol, String nombre, String descripcion, List<Users> usuario) {
	super();
	IdRol = idRol;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.usuario = usuario;
}

public int getIdRol() {
	return IdRol;
}

public void setIdRol(int idRol) {
	IdRol = idRol;
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

public List<Users> getUsuario() {
	return usuario;
}

public void setUsuario(List<Users> usuario) {
	this.usuario = usuario;
}

}
