package gaming.pe.Controller;

import gaming.pe.Service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductsService productService;
}
