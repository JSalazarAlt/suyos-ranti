package com.suyos.ranti.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a User in the system.
 * This class maps to the user table in the database and contains
 * basic user information including credentials and role assignment.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Entity
@Table(name = "user")
public class User {
    
    // Instance variables
    
    /**
     * Unique identifier for the user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Unique username for login
     */
    private String username;
    
    /**
     * User's email address
     */
    private String email;
    
    /**
     * User's password (should be encrypted)
     */
    private String password;

    /**
     * User's role in the system (stored as string in database)
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Associated person details (one-to-one relationship)
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Person person;
    
    // Constructors
    
    /**
     * Default constructor required by JPA
     */
    public User() {
    }

    /**
     * Constructor with parameters for creating a new user
     * 
     * @param username The unique username
     * @param email The user's email address
     * @param password The user's password
     * @param role The user's role in the system
     */
    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Setters and getters
    
    /**
     * Gets the user ID
     * @return The user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user ID
     * @param id The user ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email address
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user role
     * @return The user role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the user role
     * @param role The role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the associated person details
     * @return The person details
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the associated person details
     * @param person The person details to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}
