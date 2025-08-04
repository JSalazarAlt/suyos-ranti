package com.suyos.ranti.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Product in the e-commerce system.
 * This class maps to the product table in the database and
 * maintains a many-to-one relationship with Category entity.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Entity
@Table(name = "products")
public class Product {
    
    // Instance variables

    /**
     * Unique identifier for the product
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the product
     */
    private String name;

    /**
     * Detailed description of the product
     */
    private String description;

    /**
     * Price of the product using BigDecimal for precision
     */
    private BigDecimal price;

    /**
     * Available stock quantity
     */
    private int stock;

    /**
     * URL of the product image
     */
    private String imgUrl;

    /**
     * Category this product belongs to (many-to-one relationship)
     */
    @ManyToOne
    private Category category;

    /**
     * User who added this product (many-to-one relationship)
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User seller;

    // No-argument constructor

    /**
     * Default constructor required by JPA
     */
    public Product() {
    }

    /**
     * Constructor with parameters for creating a new product
     * 
     * @param name The name of the product
     * @param description The description of the product
     * @param price The price of the product
     * @param stock The available stock quantity
     * @param imgUrl The URL of the product image
     * @param category The category this product belongs to
     * @param seller The user who added this product
     */
    public Product(String name, String description, BigDecimal price, int stock, String imgUrl, Category category, User seller) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imgUrl = imgUrl;
        this.category = category;
        this.seller = seller;
    }

    // Setters and Getters

    /**
     * Gets the product ID
     * @return The product ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the product ID
     * @param id The product ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the product name
     * @return The product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name
     * @param name The product name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product description
     * @return The product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the product description
     * @param description The product description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the product price
     * @return The product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the product price
     * @param price The product price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the available stock quantity
     * @return The stock quantity
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity
     * @param stock The stock quantity to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the product image URL
     * @return The product image URL
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets the product image URL
     * @param imgUrl The product image URL to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Gets the product category
     * @return The category this product belongs to
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the product category
     * @param category The category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets the user who added this product
     * @return The user who added this product
     */
    public User getSellUser() {
        return seller;
    }

    /**
     * Sets the user who added this product
     * @param seller The user to set
     */
    public void setSellUser(User seller) {
        this.seller = seller;
    }
    
}
