package com.deliveries_microservice.deliveries.delivery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveriesController {
    @GetMapping("/deliveries")
    public String getDeliveries() {
        return "List of deliveries";
    }
}
