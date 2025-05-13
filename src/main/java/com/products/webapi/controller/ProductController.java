package com.products.webapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products.webapi.entity.Product;
import com.products.webapi.service.ProductService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "api/products", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productService.getAllProducts());

    }
}
