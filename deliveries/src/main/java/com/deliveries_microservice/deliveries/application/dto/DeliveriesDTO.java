package com.deliveries_microservice.deliveries.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO que representa una entrega en el sistema")
public class DeliveriesDTO {

    @Schema(description = "ID único de la entrega", example = "1")
    private Long id;

    @Schema(
            description = "ID de la orden asociada (UUID)",
            example = "98253a22-0b92-4934-9d7a-a12472838ad9",
            required = true
    )
    private String orderId;

    @Schema(description = "Dirección de entrega completa", example = "Calle 123 #45-67", required = true)
    private String deliveryAddress;

    @Schema(description = "Ciudad de entrega", example = "Bogotá", required = true)
    private String city;

    @Schema(description = "Teléfono de contacto del destinatario", example = "+5712345678")
    private String contactPhone;

    @Schema(description = "Fecha y hora de envío", example = "2025-01-10T08:30:00")
    private LocalDateTime shippingDate;

    @Schema(description = "Fecha y hora de entrega", example = "2025-01-12T14:15:00")
    private LocalDateTime deliveryDate;

    @Schema(description = "Estado actual de la entrega",
            example = "ENTREGADO",
            allowableValues = {"PENDIENTE", "EN_TRANSITO", "ENTREGADO", "FALLIDA", "PROGRAMADO"})
    private String deliveryStatus;

    @Schema(description = "Observaciones adicionales sobre la entrega", example = "Dejar en portería")
    private String observations;
}