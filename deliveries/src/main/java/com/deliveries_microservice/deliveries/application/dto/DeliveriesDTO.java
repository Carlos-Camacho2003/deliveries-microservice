package com.deliveries_microservice.deliveries.application.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveriesDTO {
    private Long id;
    private Integer orderId;
    private String deliveryAddress;
    private String city;
    private String contactPhone;
    private LocalDateTime shippingDate;
    private LocalDateTime deliveryDate;
    private String deliveryStatus;
    private String observations;
}