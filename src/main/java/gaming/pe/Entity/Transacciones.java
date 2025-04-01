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
@Table(name="tbl_Transaccion")
public class Transacciones {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private int IdTransacciones;

@ManyToOne
@JoinColumn(name="orden_id",nullable=false)
private Ordenes orden;

@Column(name = "Fecha_Pago", nullable = false)
private Date fecha_pago;

@Column(name = "Monto", nullable = false)
private Double monto;

public Transacciones() {
	super();
}

public Transacciones(int idTransacciones, Ordenes orden, Date fecha_pago, Double monto) {
	super();
	IdTransacciones = idTransacciones;
	this.orden = orden;
	this.fecha_pago = fecha_pago;
	this.monto = monto;
}

public int getIdTransacciones() {
	return IdTransacciones;
}

public void setIdTransacciones(int idTransacciones) {
	IdTransacciones = idTransacciones;
}

public Ordenes getOrden() {
	return orden;
}

public void setOrden(Ordenes orden) {
	this.orden = orden;
}

public Date getFecha_pago() {
	return fecha_pago;
}

public void setFecha_pago(Date fecha_pago) {
	this.fecha_pago = fecha_pago;
}

public Double getMonto() {
	return monto;
}

public void setMonto(Double monto) {
	this.monto = monto;
}

//estado
//metodo pago


}
