package com.martin.microservices.order.service;

import com.martin.microservices.order.client.InventoryClient;
import com.martin.microservices.order.dto.OrderedRequest;
import com.martin.microservices.order.event.OrderPlacedEvent;
import com.martin.microservices.order.model.Order;
import com.martin.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

// Paso 12

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    // Paso 22
    private final InventoryClient inventoryClient;

    // PASO 30
    // key = name of the topic
    private final KafkaTemplate <String, OrderPlacedEvent> kafkaTemplate;



    public void placeOrder(OrderedRequest orderedRequest){

        var isProductInStock =inventoryClient.isInStock(orderedRequest.skuCode(), orderedRequest.quantity());
        if(isProductInStock){
            Order order = new Order();
            // mapeamos
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderedRequest.price().multiply(BigDecimal.valueOf(orderedRequest.quantity())));
            order.setSkuCode(orderedRequest.skuCode());
            order.setQuantity(orderedRequest.quantity());
            // save order to orderRepository
            orderRepository.save(order);

            // PASO 30
            // Enviar mensaje a kafka topic
//            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber(), orderedRequest.userDetails().email());
//            log.info("Start - Sending OrderPlacedEvent {} to Kafka Topic order-placed", orderPlacedEvent);
//            kafkaTemplate.send("order-placed", orderPlacedEvent);
//            log.info("End - Sending OrderPlacedEvent {} to Kafka Topic order-placed", orderPlacedEvent);


        }
        else{
            throw new RuntimeException("Product with sku code " + orderedRequest.skuCode() + " is not in stock");
        }

    }
}
