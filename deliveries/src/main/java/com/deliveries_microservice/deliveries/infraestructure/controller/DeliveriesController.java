package com.deliveries_microservice.deliveries.infraestructure.controller;

import com.deliveries_microservice.deliveries.application.dto.DeliveriesDTO;
import com.deliveries_microservice.deliveries.application.service.DeliveriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@Tag(name = "Deliveries Management", description = "API para la gestión completa de pedidos y entregas")
@AllArgsConstructor
public class DeliveriesController {

    private final DeliveriesService deliveriesService;


    @Operation(summary = "Crear una nueva entrega", description = "Registra una nueva entrega en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entrega creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DeliveriesDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<DeliveriesDTO> createDelivery(
            @Parameter(description = "Datos de la entrega a crear", required = true)
            @RequestBody DeliveriesDTO deliveriesDTO) {
        DeliveriesDTO savedDelivery = deliveriesService.createDelivery(deliveriesDTO);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }


    @Operation(summary = "Obtener una entrega por ID", description = "Retorna los detalles de una entrega específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrega encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DeliveriesDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Entrega no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<DeliveriesDTO> getDeliveryById(
            @Parameter(description = "ID de la entrega a buscar", required = true, example = "1")
            @PathVariable("id") Long deliveryId) {
        DeliveriesDTO deliveriesDTO = deliveriesService.getDeliveryById(deliveryId);
        return ResponseEntity.ok(deliveriesDTO);
    }


    @Operation(summary = "Listar todas las entregas", description = "Retorna una lista paginada de todas las entregas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de entregas obtenida exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DeliveriesDTO.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<DeliveriesDTO>> getAllDeliveries() {
        List<DeliveriesDTO> deliveries = deliveriesService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }


    @Operation(
            summary = "Actualizar entrega",
            description = "Actualiza todos los datos de una entrega existente usando el ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Entrega actualizada exitosamente",
                    content = @Content(schema = @Schema(implementation = DeliveriesDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Entrega no encontrada",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<DeliveriesDTO> updateDelivery(
            @Parameter(
                    description = "ID único de la entrega a actualizar",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long deliveryId,

            @Parameter(
                    description = "Objeto Delivery con los datos actualizados",
                    required = true,
                    content = @Content(schema = @Schema(implementation = DeliveriesDTO.class))
            )
            @RequestBody DeliveriesDTO updatedDelivery) {
        DeliveriesDTO deliveriesDTO = deliveriesService.updateDelivery(deliveryId, updatedDelivery);
        return ResponseEntity.ok(deliveriesDTO);
    }


    @Operation(
            summary = "Eliminar entrega",
            description = "Elimina permanentemente una entrega del sistema usando su ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Entrega eliminada exitosamente",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Entrega no encontrada",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDelivery(
            @Parameter(
                    description = "ID único de la entrega a eliminar",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long deliveryId) {
        deliveriesService.deleteDelivery(deliveryId);
        return ResponseEntity.ok("Entrega eliminada exitosamente");
    }
}