package com.gestionpedidos.proyecto1gestionpedidos.model;

import com.gestionpedidos.proyecto1gestionpedidos.model.Order;
import com.gestionpedidos.proyecto1gestionpedidos.model.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(Order order) {
        // Ajustamos el createdAt si no viene desde el cliente
        if (order.getCreatedAt() == null) {
            order.setCreatedAt(LocalDateTime.now());
        }
        if (order.getStatus() == null) {
            order.setStatus("PENDING");
        }
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}

