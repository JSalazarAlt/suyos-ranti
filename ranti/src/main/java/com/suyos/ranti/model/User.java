package com.suyos.ranti.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails {
    
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
    
    /**
     * Indicates whether the user has accepted the terms and conditions
     * Default is false, should be set to true upon registration
     */
    private Boolean termsAccepted = false;
    
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

    // Overriding methods of UserDetails interface

    /**
     * Returns the authorities granted to the user.
     * In this case, it returns an empty collection as no specific authorities are defined.
     * 
     * @return An empty collection of GrantedAuthority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming a simple user role future provision
        // for more complex scenarios, you may want a Role entity
        // currently returns an empty list
        // return authorities if roles are added
        return Collections.emptyList();
    }

    /**
     * Gets the password
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username
     * @return The username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Checks if the account is expired
     * @return true if the account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    /**
     * Checks if the account is locked
     * @return true if the account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    /**
     * Checks if the credentials are non-expired
     * @return true if the credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    /**
     * Checks if the user is enabled
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        // Fixed values, you can have fields to represent state
        return true;
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

    /**
     * Checks if the user has accepted the terms and conditions
     * @return true if terms are accepted, false otherwise
     */
    public Boolean getTermsAccepted() {
        return termsAccepted;
    }
    
    /**
     * Sets whether the user has accepted the terms and conditions
     * @param termsAccepted true if terms are accepted, false otherwise
     */
    public void setTermsAccepted(Boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }

}
