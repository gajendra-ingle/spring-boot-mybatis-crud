package com.techpulse.learn.controller;

import com.techpulse.learn.dto.ApiResponse;
import com.techpulse.learn.entity.Order;
import com.techpulse.learn.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Create order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    // Update order
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Order not found with id: " + id, null));
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Order updated successfully", updatedOrder)
        );
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean deleted = orderService.deleteOrder(id);
        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Order with id " + id + " not found.");
        }

        return ResponseEntity.ok("Order with id " + id + " deleted successfully.");
    }

    // Get orders by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        boolean success = !orders.isEmpty();
        String message = success
                ? "Orders found successfully"
                : "No orders found for user id: " + userId;

        return ResponseEntity.ok(
                new ApiResponse<>(success, message, orders)
        );
    }

    // Count orders
    @GetMapping("/count")
    public ResponseEntity<ApiResponse<Long>> countOrders() {
        long count = orderService.countOrders();
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Total orders count retrieved", count)
        );
    }

}
