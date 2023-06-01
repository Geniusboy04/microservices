package com.example.orderservice.controller;

import com.example.orderservice.integration_dto.Product;
import com.example.orderservice.integration_services.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
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

    private static final String SERVICE_NAME = "product-service";

    private final ProductClient productClient;

    @GetMapping("/list")
    @CircuitBreaker(name = "SERVICE_NAME", fallbackMethod = "fallbackMethod")
//    @TimeLimiter(name = "product")
//    @Retry(name = "product")
    public List<Product> getList(){
        return productClient.getProducts();
    }

    public List<Product> fallbackMethod(Exception e){
        System.out.println("Circuit is fallback");
        return new ArrayList<>();
    }


}
