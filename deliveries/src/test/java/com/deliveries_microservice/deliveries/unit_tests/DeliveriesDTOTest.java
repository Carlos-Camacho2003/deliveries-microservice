package com.deliveries_microservice.deliveries.unit_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DeliveriesDTOTest {
    @Test
    void testBuilderAndGetters() {
        LocalDateTime now = LocalDateTime.now();
        DeliveriesDTO dto = DeliveriesDTO.builder()
                .id(1L)
                .orderId("order-123")
                .deliveryAddress("Calle 123")
                .city("Bogotá")
                .contactPhone("123456789")
                .shippingDate(now)
                .deliveryDate(now.plusDays(1))
                .deliveryStatus("PENDIENTE")
                .observations("Ninguna")
                .build();

        assertEquals(1L, dto.getId());
        assertEquals("order-123", dto.getOrderId());
        assertEquals("Calle 123", dto.getDeliveryAddress());
        assertEquals("Bogotá", dto.getCity());
        assertEquals("123456789", dto.getContactPhone());
        assertEquals(now, dto.getShippingDate());
        assertEquals(now.plusDays(1), dto.getDeliveryDate());
        assertEquals("PENDIENTE", dto.getDeliveryStatus());
        assertEquals("Ninguna", dto.getObservations());
    }

    @Test
    void testSetters() {
        DeliveriesDTO dto = new DeliveriesDTO();
        dto.setId(2L);
        dto.setOrderId("order-456");
        dto.setDeliveryAddress("Calle 456");
        dto.setCity("Cali");
        dto.setContactPhone("987654321");
        dto.setDeliveryStatus("ENTREGADO");
        dto.setObservations("Observación");

        assertEquals(2L, dto.getId());
        assertEquals("order-456", dto.getOrderId());
        assertEquals("Calle 456", dto.getDeliveryAddress());
        assertEquals("Cali", dto.getCity());
        assertEquals("987654321", dto.getContactPhone());
        assertEquals("ENTREGADO", dto.getDeliveryStatus());
        assertEquals("Observación", dto.getObservations());
    }
}