package com.example.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class MainController {

    @GetMapping()
    public String hello(){
        return "Inventory service says hello !!";
    }

}
