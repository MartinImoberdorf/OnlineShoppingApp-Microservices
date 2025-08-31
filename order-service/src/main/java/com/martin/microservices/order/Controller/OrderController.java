package com.martin.microservices.order.Controller;

import com.martin.microservices.order.dto.OrderedRequest;
import com.martin.microservices.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Paso 13

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderedRequest orderedRequest) {
        orderService.placeOrder(orderedRequest);
        return "Order Placed Successfully";
    }
}
