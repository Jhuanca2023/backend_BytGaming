package gaming.pe.Controller;

import gaming.pe.DTO.CategoriaDTO;
import gaming.pe.Service.CategoriaService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtenerCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Transactional
    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO nuevaCategoria = categoriaService.crear(categoriaDTO);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(id);
        CategoriaDTO categoriaActualizada = categoriaService.editar(categoriaDTO);
        return ResponseEntity.ok(categoriaActualizada);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}