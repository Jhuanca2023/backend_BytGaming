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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name ="tbl_Carrito")
public class Carrito {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int IdCarrito;

 @ManyToOne
 @JoinColumn(name ="usuario_id",nullable=false)
 private UserEntity usuario;
 
 @Column(name = "Fecha_Creacion", nullable = false)
 private Date fechaCreacion;

@OneToMany(mappedBy="carrito")
private List<DetalleCarrito> detalleCarrito;

}
