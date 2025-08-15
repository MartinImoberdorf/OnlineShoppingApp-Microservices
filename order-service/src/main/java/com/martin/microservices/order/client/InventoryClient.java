package com.martin.microservices.order.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// PASO 21

// le ponemos el nombre del cliente y la URL del servicio al que se va a conectar
@FeignClient(value = "inventory", url = "${inventory.service.url}") // la URL la vamos a definir en el application.properties
public interface InventoryClient {
    // definimos el método que queremos invocar en el servicio de inventario

    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory") // este es el endpoint que vamos a invocar en el servicio de inventario
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
