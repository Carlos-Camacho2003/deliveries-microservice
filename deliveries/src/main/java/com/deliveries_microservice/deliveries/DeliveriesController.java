package com.deliveries_microservice.deliveries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveriesController {
    @GetMapping("/deliveries")
    public String getDeliveries() {
        return "List of deliveries";
    }
}
