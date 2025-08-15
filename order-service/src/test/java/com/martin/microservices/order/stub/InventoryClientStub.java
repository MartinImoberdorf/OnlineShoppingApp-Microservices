package com.martin.microservices.order.stub;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

// aca llamamos al stub que simula el servicio de inventario
// al cliente que se comunica con el servicio de inventario
public class InventoryClientStub {
    public static void stubInventoryCall(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}
