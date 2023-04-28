package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public List<Product> getList(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int id){
        return productService.getById(id);
    }

    @GetMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        return productService.deleteById(id);
    }

}
