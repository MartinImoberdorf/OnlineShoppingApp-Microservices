package com.martin.microservices.order.dto;

import java.math.BigDecimal;

public record OrderedRequest(
        Long id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity,
        UserDetails userDetails
) {
    public record UserDetails(String email, String firstName, String lastName) {}
}
