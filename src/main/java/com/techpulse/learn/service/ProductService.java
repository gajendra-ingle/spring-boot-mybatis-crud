package com.techpulse.learn.service;

import com.techpulse.learn.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        return null; // Implement logic to retrieve all products
    }

    public Optional<Product> getProductById(Long id) {
        return Optional.empty(); // Implement logic to retrieve a product by ID
    }

    public Product saveProduct(Product product) {
        return null; // Implement logic to save a new product
    }

    public Product updateProduct(Long id, Product product) {
        return null; // Implement logic to update an existing product
    }

    public void deleteProduct(Long id) {
        // Implement logic to delete a product by ID
    }
}
