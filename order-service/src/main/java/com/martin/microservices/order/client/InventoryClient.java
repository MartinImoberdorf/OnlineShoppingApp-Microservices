package com.martin.microservices.order.client;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

// PASO 21


public interface InventoryClient {
    // definimos el método que queremos invocar en el servicio de inventario
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
