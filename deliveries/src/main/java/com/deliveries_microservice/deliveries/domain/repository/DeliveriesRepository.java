package com.deliveries_microservice.deliveries.domain.repository;

import com.deliveries_microservice.deliveries.infraestructure.persistence.entities.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Long> {

    // List<Deliveries> findByOrderId(Integer orderId);
    // List<Deliveries> findByDeliveryStatus(String status);
}