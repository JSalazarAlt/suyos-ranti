package com.suyos.ranti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity class representing a product Category.
 * This class maps to the category table in the database and
 * maintains a one-to-many relationship with Product entities.
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "categories")
public class Category {
    
    // Instance variables
    
    /**
     * Unique identifier for the category
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the category
     */
    private String name;

    /**
     * List of products belonging to this category (one-to-many relationship)
     */
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Constructors
    
    /**
     * Default constructor required by JPA
     */
    public Category() {
    }

    /**
     * Constructor with parameters for creating a new category
     * 
     * @param name The name of the category
     */
    public Category(String name) {
        this.name = name;
    }

    // Setters and getters
    
    /**
     * Gets the category ID
     * @return The category ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the category ID
     * @param id The category ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the category name
     * @return The category name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the category name
     * @param name The category name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of products in this category
     * @return The list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products in this category
     * @param products The list of products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
