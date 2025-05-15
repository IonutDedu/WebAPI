package com.products.webapi.service;

import com.products.webapi.entity.Product;
import com.products.webapi.exceptionHandler.ApiException;
import com.products.webapi.exceptionHandler.ResourceNotFoundException;
import com.products.webapi.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product product){
        Product oldProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setActive(product.getActive());
        oldProduct.setUnitPrice(product.getUnitPrice());
        oldProduct.setQty(product.getQty());
        return productRepository.save(oldProduct);
    }

    public ResponseEntity<?> deleteProduct(Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
