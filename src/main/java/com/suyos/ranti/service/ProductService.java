package com.suyos.ranti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suyos.ranti.model.Product;
import com.suyos.ranti.repository.ProductRepository;

/**
 * Service class for handling product-related business logic.
 * This service provides methods for CRUD operations on products
 * and acts as an intermediary between controllers and repositories.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Service
public class ProductService {
    
    /**
     * ProductRepository instance for database operations
     */
    private final ProductRepository productRepository;

    /**
     * Constructor for ProductService
     * @param productRepository ProductRepository instance for database operations
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves all products from the database
     * @return list of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Gets a product by its ID
     * @param id the product ID
     * @return the product if found
     * @throws RuntimeException if product not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found for id: " + id));
    }

    /**
     * Saves a product to the database
     * @param product the product to save
     */
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * Updates an existing product by its ID
     * @param id the ID of the product to update
     * @param updatedProduct the updated product data
     */
    public void updateProductById(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            productRepository.save(updatedProduct);
        }
    }

    /**
     * Deletes a product by its ID
     * @param id the ID of the product to delete
     */
    public void deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

}
