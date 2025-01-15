package com.gestionpedidos.proyecto1gestionpedidos.model;

import com.gestionpedidos.proyecto1gestionpedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

