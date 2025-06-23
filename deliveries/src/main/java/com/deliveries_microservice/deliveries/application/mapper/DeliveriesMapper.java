package com.deliveries_microservice.deliveries.application.mapper;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.infraestructure.persistence.entities.Deliveries;
import org.springframework.stereotype.Component;

@Component
public class DeliveriesMapper {

    public DeliveriesDTO toDto(Deliveries entity) {
        return DeliveriesDTO.builder()
                .id(entity.getId())
                .orderId(entity.getOrderId())
                .deliveryAddress(entity.getDeliveryAddress())
                .city(entity.getCity())
                .contactPhone(entity.getContactPhone())
                .shippingDate(entity.getShippingDate())
                .deliveryDate(entity.getDeliveryDate())
                .deliveryStatus(entity.getDeliveryStatus())
                .observations(entity.getObservations())
                .build();
    }

    public Deliveries toEntity(DeliveriesDTO dto) {
        Deliveries entity = new Deliveries();
        entity.setId(dto.getId());
        entity.setOrderId(dto.getOrderId());
        entity.setDeliveryAddress(dto.getDeliveryAddress());
        entity.setCity(dto.getCity());
        entity.setContactPhone(dto.getContactPhone());
        entity.setShippingDate(dto.getShippingDate());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setDeliveryStatus(dto.getDeliveryStatus());
        entity.setObservations(dto.getObservations());
        return entity;
    }
}