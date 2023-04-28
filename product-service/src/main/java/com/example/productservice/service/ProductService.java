package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getById(int id){
        return productRepository.findById(id).orElse(new Product());
    }
    public Product save(Product product){
        return productRepository.save(product);
    }

    public String deleteById(int id){
        productRepository.deleteById(id);
        return "Successfully Deleted !!";
    }

}
