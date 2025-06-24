package com.deliveries_microservice.deliveries.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeliveryCreationRequest {
    private String orderId;
    private String deliveryAddress;
    private String city;
    private String contactPhone;
}