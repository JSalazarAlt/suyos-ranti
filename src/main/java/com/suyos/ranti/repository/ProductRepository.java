package com.suyos.ranti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suyos.ranti.model.Product;

/**
 * Repository interface for Product entity.
 * Provides methods to perform CRUD operations on Product data.
 * Extends JpaRepository to inherit basic database operations.
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
