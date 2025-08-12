package com.martin.microservices.order.service;

import com.martin.microservices.order.dto.OrderedRequest;
import com.martin.microservices.order.model.Order;
import com.martin.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import java.util.UUID;

// Paso 12

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderedRequest orderedRequest){
        Order order = new Order();
        // mapeamos
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderedRequest.price());
        order.setSkuCode(orderedRequest.skuCode());
        order.setQuantity(orderedRequest.quantity());

        // save order to orderRepository
        orderRepository.save(order);
    }
}
