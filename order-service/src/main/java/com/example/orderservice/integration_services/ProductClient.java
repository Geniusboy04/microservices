package com.example.orderservice.integration_services;


import com.example.orderservice.integration_dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/product/list")
    List<Product> getProducts();

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    Page<Product> getStores(Pageable pageable);

    @RequestMapping(method = RequestMethod.POST, value = "/stores/{productId}", consumes = "application/json")
    Product update(@PathVariable("productId") Long productId, Product product);
}
