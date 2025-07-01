package com.suyos.ranti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suyos.ranti.model.User;

/**
 * Repository interface for User entity.
 * Provides methods to perform CRUD operations and custom queries on User data.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Finds a user by their username.
     * 
     * @param username Username to search for
     * @return User object if found, null otherwise
     */
    User findByUsername(String username);

    /**
     * Finds a user by their email address.
     * 
     * @param email Email address to search for
     * @return User object if found, null otherwise
     */
    User findByEmail(String email);
    
    /**
     * Checks if a user with the given username exists.
     * 
     * @param username Username to check
     * @return true if user exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Checks if a user with the given email exists.
     * 
     * @param email Email to check
     * @return true if user exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Finds a user by their username or email address.
     * 
     * @param username Username to search for
     * @param email Email address to search for
     * @return User object if found, null otherwise
     */
    User findByUsernameOrEmail(String username, String email);

}
