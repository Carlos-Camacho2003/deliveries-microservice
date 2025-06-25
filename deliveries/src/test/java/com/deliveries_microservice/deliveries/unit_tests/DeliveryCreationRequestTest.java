package com.deliveries_microservice.deliveries.unit_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveryCreationRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryCreationRequestTest {
    @Test
    void testSettersAndGetters() {
        DeliveryCreationRequest request = new DeliveryCreationRequest();
        request.setOrderId("order-789");
        request.setDeliveryAddress("Calle 789");
        request.setCity("Medellín");
        request.setContactPhone("5555555");

        assertEquals("order-789", request.getOrderId());
        assertEquals("Calle 789", request.getDeliveryAddress());
        assertEquals("Medellín", request.getCity());
        assertEquals("5555555", request.getContactPhone());
    }
} 