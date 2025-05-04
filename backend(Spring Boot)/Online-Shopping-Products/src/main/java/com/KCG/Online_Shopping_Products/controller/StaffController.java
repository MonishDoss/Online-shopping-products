package com.KCG.Online_Shopping_Products.controller;

import com.KCG.Online_Shopping_Products.dto.response.UserOrderSummary;
import com.KCG.Online_Shopping_Products.dto.response.OrderDetailsResponse;
import com.KCG.Online_Shopping_Products.Enum.OrderStatus;
import com.KCG.Online_Shopping_Products.service.Interface.OrderService;
import com.KCG.Online_Shopping_Products.service.Interface.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final UserService userService;
    private final OrderService orderService;

    @Operation(summary = "Get all users with their order summaries", description = "Fetch a list of users along with their order summaries.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved users and orders")
    @GetMapping("/users-with-orders")
    public ResponseEntity<List<UserOrderSummary>> getUsersWithOrders() {
        return ResponseEntity.ok(userService.getUsersWithOrderSummaries());
    }

    @Operation(summary = "Get details of a specific order", description = "Fetch details of an order by its ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved order details")
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDetailsResponse> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderDetailsById(orderId));
    }

    @Operation(summary = "Update the status of an order", description = "Update the status of an order by its ID.")
    @ApiResponse(responseCode = "200", description = "Successfully updated order status")
    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status updated to " + status);
    }

    public StaffController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }
}
