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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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




}
