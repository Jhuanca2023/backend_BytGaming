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
import lombok.Data;


@Entity
@Table (name = "tbl_Usuarios")
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int id;

@Column(name = "Nombre", nullable = false)
private String Name;

@Column(name = "Apellido", nullable = false)
private String Apellido;

@Column(name = "Perfil", nullable = false)
private String profile;

@Column(name = "Email", nullable = false)
private String email;

@Column(name = "Password", nullable = false)
private String password;

@Column(name = "Phone", nullable = false)
private String phone;

@ManyToOne
@JoinColumn(name = "rol_id", nullable = false)
private Roles roles;

@OneToMany(mappedBy = "usuario")
private List<Ordenes> ordenes;

@OneToMany(mappedBy="usuario")
private List<Carrito> carrito;

@OneToMany(mappedBy="usuario")
private List<ComentariosProducto> comentariosProducto;

public Users() {
	super();
}

public Users(int id, String name, String apellido, String profile, String email, String password, String phone,
		Roles roles, List<Ordenes> ordenes, List<Carrito> carrito, List<ComentariosProducto> comentariosProducto) {
	super();
	this.id = id;
	Name = name;
	Apellido = apellido;
	this.profile = profile;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.roles = roles;
	this.ordenes = ordenes;
	this.carrito = carrito;
	this.comentariosProducto = comentariosProducto;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getApellido() {
	return Apellido;
}

public void setApellido(String apellido) {
	Apellido = apellido;
}

public String getProfile() {
	return profile;
}

public void setProfile(String profile) {
	this.profile = profile;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public Roles getRoles() {
	return roles;
}

public void setRoles(Roles roles) {
	this.roles = roles;
}

public List<Ordenes> getOrdenes() {
	return ordenes;
}

public void setOrdenes(List<Ordenes> ordenes) {
	this.ordenes = ordenes;
}

public List<Carrito> getCarrito() {
	return carrito;
}

public void setCarrito(List<Carrito> carrito) {
	this.carrito = carrito;
}

public List<ComentariosProducto> getComentariosProducto() {
	return comentariosProducto;
}

public void setComentariosProducto(List<ComentariosProducto> comentariosProducto) {
	this.comentariosProducto = comentariosProducto;
}


}

