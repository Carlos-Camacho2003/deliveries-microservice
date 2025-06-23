package com.deliveries_microservice.deliveries.application.service.impl;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.infraestructure.persistence.entities.Deliveries;
import com.deliveries_microservice.deliveries.application.mapper.DeliveriesMapper;
import com.deliveries_microservice.deliveries.domain.repository.DeliveriesRepository;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveriesServiceImpl implements DeliveriesService {

    private DeliveriesRepository deliveriesRepository;
    private DeliveriesMapper deliveriesMapper;

    @Override
    public DeliveriesDTO createDelivery(DeliveriesDTO deliveriesDTO) {
        Deliveries delivery = deliveriesMapper.toEntity(deliveriesDTO);
        Deliveries savedDelivery = deliveriesRepository.save(delivery);
        return deliveriesMapper.toDto(savedDelivery);
    }

    @Override
    public DeliveriesDTO getDeliveryById(Long deliveryId) {
        Deliveries delivery = deliveriesRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + deliveryId));
        return deliveriesMapper.toDto(delivery);
    }

    @Override
    public List<DeliveriesDTO> getAllDeliveries() {
        List<Deliveries> deliveries = deliveriesRepository.findAll();
        return deliveries.stream()
                .map(deliveriesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveriesDTO updateDelivery(Long deliveryId, DeliveriesDTO updatedDelivery) {
        Deliveries existingDelivery = deliveriesRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + deliveryId));

        existingDelivery.setOrderId(updatedDelivery.getOrderId());
        existingDelivery.setDeliveryAddress(updatedDelivery.getDeliveryAddress());
        existingDelivery.setCity(updatedDelivery.getCity());
        existingDelivery.setContactPhone(updatedDelivery.getContactPhone());
        existingDelivery.setShippingDate(updatedDelivery.getShippingDate());
        existingDelivery.setDeliveryDate(updatedDelivery.getDeliveryDate());
        existingDelivery.setDeliveryStatus(updatedDelivery.getDeliveryStatus());
        existingDelivery.setObservations(updatedDelivery.getObservations());

        Deliveries updatedDeliveryEntity = deliveriesRepository.save(existingDelivery);
        return deliveriesMapper.toDto(updatedDeliveryEntity);
    }

    @Override
    public void deleteDelivery(Long deliveryId) {
        deliveriesRepository.deleteById(deliveryId);
    }
}