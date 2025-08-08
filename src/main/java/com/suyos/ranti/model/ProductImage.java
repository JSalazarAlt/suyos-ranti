package com.suyos.ranti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a product image.
 * This class maps to the product_images table and maintains
 * a many-to-one relationship with Product entity.
 * 
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "product_images")
public class ProductImage {
    
    /**
     * Unique identifier for the product image
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Associated product (many-to-one relationship)
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    /**
     * URL path to the image file
     */
    private String imageUrl;
    
    /**
     * Display order for image carousel
     */
    private Integer displayOrder = 0;
    
    /**
     * Default constructor required by JPA
     */
    public ProductImage() {}
    
    /**
     * Constructor with parameters for creating a new product image
     * 
     * 
     * @param product the associated product
     * @param imageUrl the URL path to the image
     * @param displayOrder the display order for carousel
     */
    public ProductImage(Product product, String imageUrl, Integer displayOrder) {
        this.product = product;
        this.imageUrl = imageUrl;
        this.displayOrder = displayOrder;
    }
    
    /**
     * Gets the image ID
     * 
     * @return the image ID
     */
    public Long getId() { return id; }
    
    /**
     * Sets the image ID
     * 
     * @param id the image ID to set
     */
    public void setId(Long id) { this.id = id; }
    
    /**
     * Gets the associated product
     * 
     * @return the associated product
     */
    public Product getProduct() { return product; }
    
    /**
     * Sets the associated product
     * 
     * @param product the product to set
     */
    public void setProduct(Product product) { this.product = product; }
    
    /**
     * Gets the image URL
     * 
     * @return the image URL
     */
    public String getImageUrl() { return imageUrl; }
    
    /**
     * Sets the image URL
     * 
     * @param imageUrl the image URL to set
     */
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    /**
     * Gets the display order
     * 
     * @return the display order
     */
    public Integer getDisplayOrder() { return displayOrder; }
    
    /**
     * Sets the display order
     * 
     * @param displayOrder the display order to set
     */
    public void setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }
}