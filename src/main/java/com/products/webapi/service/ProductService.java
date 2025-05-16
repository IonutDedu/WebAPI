package com.products.webapi.service;

import com.products.webapi.entity.Product;
import com.products.webapi.exceptionHandler.ResourceNotFoundException;
import com.products.webapi.repository.ProductRepository;
import org.hibernate.JDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        logger.info("Getting all products.");
        try {
            return productRepository.findAll();
        } catch (JDBCException e){
            logger.error(e.getMessage());
            return null;
        }
    }

    public Product getProductById(Integer id){
        logger.info("Get product by ID: " + id);
        try {
            return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        } catch (JDBCException e){
            logger.error(e.getMessage());
            return null;
        }
    }

    public Product saveProduct(Product product){
        logger.info("Save product with Name: " + product.getName() + ", " + product.getDescription());
        try {
        return productRepository.save(product);
        } catch (JDBCException e){
            logger.error(e.getMessage());
            return null;
        }
    }

    public Product updateProduct(Integer id, Product product){
        logger.info("Update product with ID: " + id + " with: " + product.toString());
        try {
            Product oldProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
            oldProduct.setName(product.getName());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setActive(product.getActive());
            oldProduct.setUnitPrice(product.getUnitPrice());
            oldProduct.setQty(product.getQty());
            return productRepository.save(oldProduct);
        } catch (JDBCException e){
            logger.error(e.getMessage());
            return null;
        }
    }

    public ResponseEntity<?> deleteProduct(Integer id){
        logger.info("Delete product with ID: " + id);
        try {
            Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        } catch (JDBCException e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
