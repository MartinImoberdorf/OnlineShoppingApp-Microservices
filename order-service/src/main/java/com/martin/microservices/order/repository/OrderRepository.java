package com.martin.microservices.order.repository;

import com.martin.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// Paso 11
public interface OrderRepository extends JpaRepository<Order, Long> {
}
