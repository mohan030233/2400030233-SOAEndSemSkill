package com.fooddelivery.restaurant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "service", "Restaurant Service",
            "status", "UP",
            "message", "Restaurant Service is registered with Eureka",
            "port", serverPort
        );
    }

    @GetMapping("/restaurants")
    public Map<String, Object> restaurants() {
        return Map.of(
            "service", "Restaurant Service",
            "port", serverPort,
            "restaurants", new String[] {
                "Spice Garden",
                "Food Palace",
                "Tasty Bites"
            }
        );
    }
}
