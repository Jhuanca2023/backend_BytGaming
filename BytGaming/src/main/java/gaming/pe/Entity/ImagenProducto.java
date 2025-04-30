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
@Table(name = "tbl_ImagenUrl")
public class ImagenProducto {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int IdImagenPro;

@ManyToOne
@JoinColumn(name ="producto_id",nullable=false)
private Productos productos;

@Column(name = "URL_Image", nullable = false)
private String url_imagen;

@Column(name = "Alt_Text", nullable = false)
private String alt_text;

public ImagenProducto() {
	super();
}

public ImagenProducto(int idImagenPro, Productos productos, String url_imagen, String alt_text) {
	super();
	IdImagenPro = idImagenPro;
	this.productos = productos;
	this.url_imagen = url_imagen;
	this.alt_text = alt_text;
}

public int getIdImagenPro() {
	return IdImagenPro;
}

public void setIdImagenPro(int idImagenPro) {
	IdImagenPro = idImagenPro;
}

public Productos getProductos() {
	return productos;
}

public void setProductos(Productos productos) {
	this.productos = productos;
}

public String getUrl_imagen() {
	return url_imagen;
}

public void setUrl_imagen(String url_imagen) {
	this.url_imagen = url_imagen;
}

public String getAlt_text() {
	return alt_text;
}

public void setAlt_text(String alt_text) {
	this.alt_text = alt_text;
}

}
