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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tbl_Ordenes")
public class Ordenes {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int IdOrden;

@ManyToOne
@JoinColumn(name = "usuario_id", nullable=false)
private Users usuario;

@Column(name = "Fecha", nullable = false)
private Date fecha;

@Column(name = "Total", nullable = false)
private Double total;
//enum estado

@OneToMany(mappedBy = "orden")
private List<DetalleOrdenes> detalles;

@OneToOne(mappedBy = "orden")
private Transacciones transaccion;

public Ordenes() {
	super();
}

public Ordenes(int idOrden, Users usuario, Date fecha, Double total, List<DetalleOrdenes> detalles,
		Transacciones transaccion) {
	super();
	IdOrden = idOrden;
	this.usuario = usuario;
	this.fecha = fecha;
	this.total = total;
	this.detalles = detalles;
	this.transaccion = transaccion;
}

public int getIdOrden() {
	return IdOrden;
}

public void setIdOrden(int idOrden) {
	IdOrden = idOrden;
}

public Users getUsuario() {
	return usuario;
}

public void setUsuario(Users usuario) {
	this.usuario = usuario;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public Double getTotal() {
	return total;
}

public void setTotal(Double total) {
	this.total = total;
}

public List<DetalleOrdenes> getDetalles() {
	return detalles;
}

public void setDetalles(List<DetalleOrdenes> detalles) {
	this.detalles = detalles;
}

public Transacciones getTransaccion() {
	return transaccion;
}

public void setTransaccion(Transacciones transaccion) {
	this.transaccion = transaccion;
}




}
