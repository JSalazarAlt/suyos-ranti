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
     * @param firstName The person's first name
     * @param middleName The person's middle name
     * @param lastName The person's last name
     * @param address The person's address
     * @param phone The person's phone number
     * @param user The associated user account
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
     * @return The person ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the person ID
     * @param id The person ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the middle name
     * @return The middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name
     * @param middleName The middle name to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the address
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address
     * @param address The address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number
     * @return The phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number
     * @param phone The phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the associated user
     * @return The associated user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the associated user
     * @param user The user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    // Utility methods
    
    /**
     * Gets the full name by combining first and last name
     * @return The full name (firstName + lastName)
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
