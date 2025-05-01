package gaming.pe.Controller;

import gaming.pe.Entity.Cart;
import gaming.pe.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // Crear un carrito para un usuario
    @PostMapping("/create/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart createCartForUser(@PathVariable Long userId) {
        return cartService.createCartForUser(userId);
    }

    // Obtener o crear un carrito para un usuario
    @GetMapping("/{userId}")
    public Cart getOrCreateCart(@PathVariable Long userId) {
        return cartService.getOrCreateCart(userId);
    }

    // Agregar un producto al carrito
    @PostMapping("/add/{userId}/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void addProductToCart(@PathVariable Long userId,
                                 @PathVariable Long productId,
                                 @RequestParam int quantity) {
        cartService.addProductToCart(userId, productId, quantity);
    }

    // Eliminar un producto del carrito
    @DeleteMapping("/remove/{userId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProductFromCart(@PathVariable Long userId,
                                      @PathVariable Long productId) {
        cartService.removeProductFromCart(userId, productId);
    }

    // Limpiar el carrito de un usuario
    @DeleteMapping("/clear/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}
