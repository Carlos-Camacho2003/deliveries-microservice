package com.deliveries_microservice.deliveries.infraestructure.clients;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeliveryEvent(
        UUID orderId,
        UUID deliveryId,
        LocalDateTime estimatedDeliveryTime,
        String status
) {}
