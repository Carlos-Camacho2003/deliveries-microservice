package com.deliveries_microservice.deliveries.unit_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.mapper.DeliveriesMapper;
import com.deliveries_microservice.deliveries.infraestructure.persistence.entities.Deliveries;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DeliveriesMapperTest {

    private final DeliveriesMapper mapper = new DeliveriesMapper();

    @Test
    void testToDto_MapeaCorrectamente() {
        // Configuración
        Deliveries entity = Deliveries.builder()
                .id(1L)
                .orderId("98253a22-0b92-4934-9d7a-a12472838ad9")
                .deliveryAddress("Calle 123")
                .city("Bogotá")
                .contactPhone("+573001234567")
                .shippingDate(LocalDateTime.now())
                .deliveryDate(LocalDateTime.now().plusDays(2))
                .deliveryStatus("ENTREGADO")
                .observations("Paquete frágil")
                .build();

        // Ejecución
        DeliveriesDTO dto = mapper.toDto(entity);

        // Verificación
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getOrderId(), dto.getOrderId());
        assertEquals(entity.getDeliveryStatus(), dto.getDeliveryStatus());
    }

    @Test
    void testToEntity_MapeaCorrectamente() {
        // Configuración
        DeliveriesDTO dto = DeliveriesDTO.builder()
                .id(1L)
                .orderId("98253a22-0b92-4934-9d7a-a12472838ad9")
                .deliveryAddress("Calle 456")
                .city("Medellín")
                .deliveryStatus("PENDIENTE")
                .build();

        // Ejecución
        Deliveries entity = mapper.toEntity(dto);

        // Verificación
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getOrderId(), entity.getOrderId());
        assertEquals(dto.getDeliveryStatus(), entity.getDeliveryStatus());
    }
}