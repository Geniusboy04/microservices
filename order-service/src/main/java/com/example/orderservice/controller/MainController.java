package com.example.orderservice.controller;

import com.example.orderservice.integration_dto.Product;
import com.example.orderservice.integration_services.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/")
public class MainController {

    public static final String ORDER_SERVICE = "orderService";

    private final ProductClient productClient;

    @GetMapping("/list")
    @Retry(name = ORDER_SERVICE,fallbackMethod = "retryMethod")
    public List<Product> getList(){
        return productClient.getProducts();
    }

    public List<Product> retryMethod(){
        return new ArrayList<>();
    }


}
