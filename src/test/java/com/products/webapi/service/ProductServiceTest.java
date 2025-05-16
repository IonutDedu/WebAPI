package com.products.webapi.service;

import com.products.webapi.entity.Product;
import com.products.webapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveProductTest(){

        Product productToSave = new Product("Guitar", "Ibanez guitar GSR60X", 1337, 1, 2);
        Product productSaved = new Product("Guitar", "Ibanez guitar GSR60X", 1337, 1, 2);

        when(productRepository.save(productToSave)).thenReturn(productSaved);

        Product productSavedReturned = productService.saveProduct(productSaved);

        assertEquals(productToSave.getName(), productSaved.getName());
        assertEquals(productToSave.getDescription(), productSaved.getDescription());
        assertEquals(productToSave.getUnitPrice(), productSaved.getUnitPrice());
        assertEquals(productToSave.getQty(), productSaved.getQty());

    }
}