package com.martin.microservices.order.service;

import com.martin.microservices.order.client.InventoryClient;
import com.martin.microservices.order.dto.OrderedRequest;
import com.martin.microservices.order.model.Order;
import com.martin.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import java.util.UUID;

// Paso 12

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    // Paso 22
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderedRequest orderedRequest){

        var isProductInStock =inventoryClient.isInStock(orderedRequest.skuCode(), orderedRequest.quantity());
        if(isProductInStock){
            Order order = new Order();
            // mapeamos
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderedRequest.price());
            order.setSkuCode(orderedRequest.skuCode());
            order.setQuantity(orderedRequest.quantity());

            // save order to orderRepository
            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("Product with sku code " + orderedRequest.skuCode() + " is not in stock");
        }

    }
}
