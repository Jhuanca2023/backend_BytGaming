package gaming.pe.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import gaming.pe.DTO.ProductCreateDTO;
import gaming.pe.Entity.Product;
import gaming.pe.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> optional = productService.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> createProduct(@RequestParam("product") String item, @RequestParam("file") MultipartFile file) throws IOException {
        try {
            // Convertimos el JSON a un objeto Book
            ObjectMapper objectMapper = new ObjectMapper();
            ProductCreateDTO productCreateDTO = objectMapper.readValue(item, ProductCreateDTO.class);

            var result = productService.save(productCreateDTO, file);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProductImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        // Llama al servicio que encapsula la lógica de Cloudinary + BD
        Product updatedProduct = productService.updateImage(id, file);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestParam("product") String item, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            // 1. Convertir el JSON a DTO
            ObjectMapper objectMapper = new ObjectMapper();
            ProductCreateDTO dto = objectMapper.readValue(item, ProductCreateDTO.class);

            // 2. Llamar al servicio de actualización (puede lanzar IOException)
            Product updated = productService.update(id, dto, file);

            // 3. Devolver el producto actualizado
            return ResponseEntity.ok(updated);

        } catch (IOException e) {
            // Error al procesar el archivo o JSON
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (RuntimeException e) {
            // Por ejemplo, producto no encontrado o categoría inválida
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IOException {
        Optional<Product> book = productService.findById(id);
        if (book.isPresent()) {
            productService.delete(book.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

