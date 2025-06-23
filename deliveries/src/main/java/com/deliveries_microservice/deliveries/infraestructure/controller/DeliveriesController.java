package com.deliveries_microservice.deliveries.infraestructure.controller;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@AllArgsConstructor
public class DeliveriesController {

    private final DeliveriesService deliveriesService;

    @PostMapping
    public ResponseEntity<DeliveriesDTO> createDelivery(@RequestBody DeliveriesDTO deliveriesDTO) {
        DeliveriesDTO savedDelivery = deliveriesService.createDelivery(deliveriesDTO);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DeliveriesDTO> getDeliveryById(@PathVariable("id") Long deliveryId) {
        DeliveriesDTO deliveriesDTO = deliveriesService.getDeliveryById(deliveryId);
        return ResponseEntity.ok(deliveriesDTO);
    }

    @GetMapping
    public ResponseEntity<List<DeliveriesDTO>> getAllDeliveries() {
        List<DeliveriesDTO> deliveries = deliveriesService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }

    @PutMapping("{id}")
    public ResponseEntity<DeliveriesDTO> updateDelivery(@PathVariable("id") Long deliveryId,
                                                        @RequestBody DeliveriesDTO updatedDelivery) {
        DeliveriesDTO deliveriesDTO = deliveriesService.updateDelivery(deliveryId, updatedDelivery);
        return ResponseEntity.ok(deliveriesDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable("id") Long deliveryId) {
        deliveriesService.deleteDelivery(deliveryId);
        return ResponseEntity.ok("Delivery deleted successfully!");
    }
}