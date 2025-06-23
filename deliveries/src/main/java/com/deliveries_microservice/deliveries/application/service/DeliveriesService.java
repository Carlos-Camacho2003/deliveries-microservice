package com.deliveries_microservice.deliveries.application.service;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import java.util.List;

public interface DeliveriesService {
    DeliveriesDTO createDelivery(DeliveriesDTO deliveriesDTO);
    DeliveriesDTO getDeliveryById(Long deliveryId);
    List<DeliveriesDTO> getAllDeliveries();
    DeliveriesDTO updateDelivery(Long deliveryId, DeliveriesDTO updatedDelivery);
    void deleteDelivery(Long deliveryId);
}