package com.deliveries_microservice.deliveries.infraestructure.clients;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderDto(
        UUID orderId,
        UUID userId,
        String customerEmail,
        List<OrderItem> items,
        LocalDateTime createdAt
) {
    public record OrderItem(
            Long productId,
            String productName,
            int quantity,
            BigDecimal price
    ) {}
}

