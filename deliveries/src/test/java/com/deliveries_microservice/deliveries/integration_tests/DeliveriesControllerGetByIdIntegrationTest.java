package com.deliveries_microservice.deliveries.integration_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DeliveriesControllerGetByIdIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveriesService deliveriesService;

    @Test
    void getDeliveryById_ReturnsDelivery() throws Exception {
        DeliveriesDTO dto = DeliveriesDTO.builder()
                .id(10L)
                .orderId("order-10")
                .deliveryAddress("Calle 10")
                .city("Cali")
                .contactPhone("555555")
                .deliveryStatus("ENTREGADO")
                .build();

        when(deliveriesService.getDeliveryById(anyLong())).thenReturn(dto);

        mockMvc.perform(get("/api/deliveries/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.orderId").value("order-10"))
                .andExpect(jsonPath("$.deliveryAddress").value("Calle 10"))
                .andExpect(jsonPath("$.city").value("Cali"))
                .andExpect(jsonPath("$.contactPhone").value("555555"))
                .andExpect(jsonPath("$.deliveryStatus").value("ENTREGADO"));
    }
} 