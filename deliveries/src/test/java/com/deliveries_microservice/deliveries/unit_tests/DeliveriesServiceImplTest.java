package com.deliveries_microservice.deliveries.unit_tests;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.mapper.DeliveriesMapper;
import com.deliveries_microservice.deliveries.application.service.impl.DeliveriesServiceImpl;
import com.deliveries_microservice.deliveries.domain.repository.DeliveriesRepository;
import com.deliveries_microservice.deliveries.infraestructure.persistence.entities.Deliveries;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveriesServiceImplTest {

    @Mock
    private DeliveriesRepository repository;

    @Mock
    private DeliveriesMapper mapper;

    @InjectMocks
    private DeliveriesServiceImpl service;

    @Test
    void testCreateDelivery_Exitoso() {
        // Configuración
        DeliveriesDTO dto = new DeliveriesDTO();
        dto.setDeliveryAddress("Calle 123");

        Deliveries entity = new Deliveries();
        entity.setId(1L);

        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(dto);

        // Ejecución
        DeliveriesDTO result = service.createDelivery(dto);

        // Verificación
        assertNotNull(result);
        verify(repository, times(1)).save(entity);
    }

    @Test
    void testGetDeliveryById_NotFound() {
        // Configuración
        when(repository.findById(1L)).thenReturn(Optional.empty());

        // Ejecución y Verificación
        assertThrows(RuntimeException.class, () -> service.getDeliveryById(1L));
    }
}
