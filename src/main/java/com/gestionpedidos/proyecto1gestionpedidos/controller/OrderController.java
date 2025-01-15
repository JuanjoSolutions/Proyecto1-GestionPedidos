package com.gestionpedidos.proyecto1gestionpedidos.controller;

import com.gestionpedidos.proyecto1gestionpedidos.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestionpedidos.proyecto1gestionpedidos.model.OrderService;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // Inyección de dependencias vía constructor
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST /api/orders
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Crea el pedido con las líneas que vengan en JSON
        Order savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    // GET /api/orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        // Devuelve todos los pedidos
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // GET /api/orders/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        // Busca un pedido por su ID
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}



