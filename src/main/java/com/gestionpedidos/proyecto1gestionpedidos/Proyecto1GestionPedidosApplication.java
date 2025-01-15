package com.gestionpedidos.proyecto1gestionpedidos;

import com.gestionpedidos.proyecto1gestionpedidos.model.Order;
import com.gestionpedidos.proyecto1gestionpedidos.model.OrderLine;
import com.gestionpedidos.proyecto1gestionpedidos.model.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Proyecto1GestionPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(Proyecto1GestionPedidosApplication.class, args);
    }

    // Creamos algunos pedidos de ejemplo al iniciar la aplicación e indicamos la URL para verlos
    @Bean
    public org.springframework.boot.CommandLineRunner initData(OrderRepository orderRepository) {
        return args -> {
            // Pedido #1
            Order order1 = new Order("PENDING", LocalDateTime.now().plusMinutes(5));
            order1.setOrderLines(List.of(
                    new OrderLine("Producto A1", 3),
                    new OrderLine("Producto B1", 1)
            ));
            orderRepository.save(order1);

            // Pedido #2
            Order order2 = new Order("PENDING", LocalDateTime.now().plusMinutes(10));
            order2.setOrderLines(List.of(
                    new OrderLine("Producto A2", 2),
                    new OrderLine("Producto B2", 5)
            ));
            orderRepository.save(order2);

            // Pedido #3
            Order order3 = new Order("PROCESSING", LocalDateTime.now().plusMinutes(15));
            order3.setOrderLines(List.of(
                    new OrderLine("Producto A3", 1),
                    new OrderLine("Producto B3", 2)
            ));
            orderRepository.save(order3);

            // Pedido #4
            Order order4 = new Order("SHIPPED", LocalDateTime.now().plusMinutes(20));
            order4.setOrderLines(List.of(
                    new OrderLine("Producto A4", 10),
                    new OrderLine("Producto B4", 1)
            ));
            orderRepository.save(order4);

            // Pedido #5
            Order order5 = new Order("DELIVERED", LocalDateTime.now().plusMinutes(25));
            order5.setOrderLines(List.of(
                    new OrderLine("Producto A5", 7),
                    new OrderLine("Producto B5", 3)
            ));
            orderRepository.save(order5);

            System.out.println(">> Se han creado 5 pedidos de ejemplo al iniciar la aplicación. " +
                    "Puedes revisarlos en la URL: http://localhost:8080/api/orders <<" + "\n<< Puedes entrar en la base " +
                    "de datos (dejar password en blanco) accediendo a la URL: http://localhost:8080/h2-console >>");
        };
    }
}

