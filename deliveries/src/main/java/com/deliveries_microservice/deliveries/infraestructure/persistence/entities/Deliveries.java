package com.deliveries_microservice.deliveries.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos_entregas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orden_id", nullable = false)
    private Integer orderId;

    @Column(name = "direccion_entrega", nullable = false)
    private String deliveryAddress;

    @Column(name = "ciudad", length = 100, nullable = false)
    private String city;

    @Column(name = "telefono_contacto", length = 20)
    private String contactPhone;

    @Column(name = "fecha_envio")
    private LocalDateTime shippingDate;

    @Column(name = "fecha_entrega")
    private LocalDateTime deliveryDate;

    @Column(name = "estado_entrega", length = 50)
    private String deliveryStatus;

    @Column(name = "observaciones")
    private String observations;
}