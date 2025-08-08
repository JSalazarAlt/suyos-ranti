package com.suyos.ranti.model;

/**
 * Enumeration representing user roles in the system.
 * Defines different permission levels and access rights for users.
 * 
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
public enum Role {
    /** Customer role with shopping permissions */
    CUSTOMER("Shopping permissions"), 
    
    /** Administrator role with full system access */
    ADMIN("Full system access");
    
    // Instance variables
    
    /**
     * Description of the role's permissions
     */
    private final String description;
    
    // Constructor
    
    /**
     * Constructor for Role enum
     * 
     * @param description The description of the role's permissions
     * @since 1.0
     */
    Role(String description) {
        this.description = description;
    }

    // Getter
    
    /**
     * Gets the role description
     * 
     * @return the description of the role's permissions
     */
    public String getDescription() {
        return description;
    }
}