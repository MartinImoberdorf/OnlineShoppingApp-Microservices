package com.martin.microservices.order.dto;

import java.math.BigDecimal;

public record OrderedRequest(
        Long id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {}
