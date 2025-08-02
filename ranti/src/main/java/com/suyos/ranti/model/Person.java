package com.suyos.ranti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Person with personal details.
 * This class contains personal information associated with a User
 * and maintains a one-to-one relationship with the User entity.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Entity
@Table(name = "person")
public class Person {
    
    // Instance variables
    
    /**
     * Unique identifier for the person
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Person's first name
     */
    private String firstName;
    
    /**
     * Person's last name
     */
    private String lastName;
    
    /**
     * Person's middle name
     */
    private String middleName;
    
    /**
     * Person's address
     */
    private String address;
    
    /**
     * Person's phone number
     */
    private String phone;

    /**
     * Associated user account (one-to-one relationship)
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    
    /**
     * Default constructor required by JPA
     */
    public Person() {
    }

    /**
     * Constructor with parameters for creating a new person
     * 
     * @param firstName the person's first name
     * @param middleName the person's middle name
     * @param lastName the person's last name
     * @param address the person's address
     * @param phone the person's phone number
     * @param user the associated user account
     */
    public Person(String firstName, String middleName, String lastName, String address, String phone, User user) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.user = user;
    }

    // Setters and getters
    
    /**
     * Gets the person ID
     * @return the person ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the person ID
     * @param id the person ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the middle name
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name
     * @param middleName the middle name to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the address
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number
     * @param phone the phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the associated user
     * @return the associated user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the associated user
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    // Utility methods
    
    /**
     * Gets the full name by combining first and last name
     * @return the full name (firstName + lastName)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
