package com.deliveries_microservice.deliveries.unit_tests;



import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.dto.DeliveryCreationRequest;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import com.deliveries_microservice.deliveries.infraestructure.controller.DeliveriesController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveriesControllerTest {

    @Mock
    private DeliveriesService service;

    @InjectMocks
    private DeliveriesController controller;

    @Test
    void testCreateDelivery_Returns201() {
        // Configuración
        DeliveryCreationRequest request = new DeliveryCreationRequest();
        request.setOrderId("98253a22-0b92-4934-9d7a-a12472838ad9");

        DeliveriesDTO dto = new DeliveriesDTO();
        dto.setId(1L);

        when(service.createDelivery(any())).thenReturn(dto);

        // Ejecución
        ResponseEntity<DeliveriesDTO> response = controller.createDelivery(request);

        // Verificación
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetAllDeliveries_ReturnsList() {
        // Configuración
        when(service.getAllDeliveries()).thenReturn(List.of(new DeliveriesDTO()));

        // Ejecución
        ResponseEntity<List<DeliveriesDTO>> response = controller.getAllDeliveries();

        // Verificación
        assertEquals(1, response.getBody().size());
    }
}