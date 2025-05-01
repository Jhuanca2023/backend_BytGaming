package gaming.pe.Controller;

import gaming.pe.DTO.KardexDTO;
import gaming.pe.Entity.Kardex;
import gaming.pe.Service.IKardexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kardex")
@RequiredArgsConstructor
public class KardexController {
    private final IKardexService service;

    @GetMapping
    public ResponseEntity<List<Kardex>> getAll() {
        List<Kardex> kardexList = service.findAll();
        return ResponseEntity.ok(kardexList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kardex> getById(@PathVariable Long id) {
        Optional<Kardex> optional = service.FindById(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kardex> create(@RequestBody KardexDTO dto) {
        try {
            Kardex created = service.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kardex> update(@PathVariable Long id, @RequestBody KardexDTO dto) {
        try {
            Kardex updated = service.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}