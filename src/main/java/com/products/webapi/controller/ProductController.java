package com.products.webapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.products.webapi.entity.Product;
import com.products.webapi.exceptionHandler.ResourceNotFoundException;
import com.products.webapi.service.ProductService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "api/product/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));

    }

    @PostMapping(value = "api/add-product", produces = "application/json")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping(value = "api/update-product/{id}", produces = "application/json")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(value = "api/delete-product/{id}", produces = "application/json")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }


}
