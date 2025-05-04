package com.KCG.Online_Shopping_Products.controller;

import com.KCG.Online_Shopping_Products.dto.request.AddToCartRequest;
import com.KCG.Online_Shopping_Products.dto.request.CartItemRequest;
import com.KCG.Online_Shopping_Products.entity.Cart;
import com.KCG.Online_Shopping_Products.entity.Order;
import com.KCG.Online_Shopping_Products.entity.Product;
import com.KCG.Online_Shopping_Products.service.Interface.CartService;
import com.KCG.Online_Shopping_Products.service.Interface.OrderService;
import com.KCG.Online_Shopping_Products.service.Interface.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer API", description = "Operations for customers: view products, manage cart, and orders")
public class CustomerController {

    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;

    public CustomerController(ProductService productService, CartService cartService, OrderService orderService) {
        this.productService = productService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    @Operation(summary = "Get all products")
    @ApiResponse(responseCode = "200", description = "List of products",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "Get a product by ID")
    @ApiResponse(responseCode = "200", description = "Product details",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)))
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/cart")
    @Operation(summary = "Add product to cart")
    @ApiResponse(responseCode = "200", description = "Product added to cart",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cart.class)))
    public Cart addToCart(@RequestBody AddToCartRequest request) {
        return cartService.addItemToCart(request.getUserId(), new CartItemRequest(null, request.getProductId(), request.getQuantity()));
    }


    @DeleteMapping("/cart")
    @Operation(summary = "Remove product from cart")
    @ApiResponse(responseCode = "200", description = "Product removed from cart")
    public ResponseEntity<String> removeFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        cartService.removeItemFromCart(userId, productId);
        return ResponseEntity.ok("Product removed from cart");
    }

    @DeleteMapping("/cart/clear")
    @Operation(summary = "Clear the entire cart")
    @ApiResponse(responseCode = "200", description = "Cart cleared")
    public ResponseEntity<String> clearCart(@RequestParam Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared");
    }

    @PostMapping("/orders")
    @Operation(summary = "Place an order")
    @ApiResponse(responseCode = "200", description = "Order placed successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)))
    public Order placeOrder(@RequestParam Long userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/orders")
    @Operation(summary = "Get order history")
    @ApiResponse(responseCode = "200", description = "Order history fetched",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)))
    public List<Order> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
