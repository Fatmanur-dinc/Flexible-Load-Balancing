package com.loadbalancing.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.instance-id:unknown}")
    private String instanceId;

    @GetMapping
    public Map<String, Object> getProducts() {
        return Map.of(
            "instance", instanceId,
            "port", port,
            "products", List.of(
                Map.of("id", 1, "name", "Laptop", "price", 15000),
                Map.of("id", 2, "name", "Phone", "price", 8000),
                Map.of("id", 3, "name", "Tablet", "price", 5000)
            )
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "instance", instanceId,
            "port", port
        );
    }
}