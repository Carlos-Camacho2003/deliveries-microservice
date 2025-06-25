package com.deliveries_microservice.deliveries.integration_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.dto.DeliveryCreationRequest;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DeliveriesControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DeliveriesService deliveriesService;

    @Test
    void createDelivery_ReturnsCreated() throws Exception {
        DeliveryCreationRequest request = new DeliveryCreationRequest();
        request.setOrderId("order-1");
        request.setDeliveryAddress("Calle 1");
        request.setCity("Bogotá");
        request.setContactPhone("123456");

        DeliveriesDTO responseDto = DeliveriesDTO.builder()
                .id(1L)
                .orderId(request.getOrderId())
                .deliveryAddress(request.getDeliveryAddress())
                .city(request.getCity())
                .contactPhone(request.getContactPhone())
                .deliveryStatus("PENDIENTE")
                .build();

        when(deliveriesService.createDelivery(any(DeliveriesDTO.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/deliveries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.orderId").value("order-1"))
                .andExpect(jsonPath("$.deliveryAddress").value("Calle 1"))
                .andExpect(jsonPath("$.city").value("Bogotá"))
                .andExpect(jsonPath("$.contactPhone").value("123456"))
                .andExpect(jsonPath("$.deliveryStatus").value("PENDIENTE"));
    }
} 