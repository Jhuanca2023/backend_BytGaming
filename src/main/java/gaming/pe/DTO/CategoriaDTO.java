package gaming.pe.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private String description;
    private List<ProductoDTO> productos;
}
