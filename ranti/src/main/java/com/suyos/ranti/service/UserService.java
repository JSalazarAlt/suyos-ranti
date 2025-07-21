package com.suyos.ranti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.suyos.ranti.model.User;
import com.suyos.ranti.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    /**
     * UserRepository instance for database operations
     */
    private final UserRepository userRepository;

    /**
     * Password encoder for encrypting user passwords
     */
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Constructor for UserService
     * @param userRepository UserRepository instance for database operations
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Registers a new user in the system.
     * 
     * @param user User object containing user details
     * @return The saved User object
     * @throws Exception if the username already exists
     */
    public User registerUser(User user) throws Exception {

        // Check if the username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("Username already exists");
        }

        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set terms accepted to true
        user.setTermsAccepted(true);

        // Save the new user
        return userRepository.save(user);
    }

    /**
     * Checks if a user with the given username or email exists.
     * 
     * @param usernameOrEmail Username or email to check
     * @return User object if found, null otherwise
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Finds a user by their email address.
     * 
     * @param email Email address to search for
     * @return User object if found, null otherwise
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Saves the user information.
     * 
     * @param user User object to save
     */
    public void save(User user) {
        userRepository.save(user);
    }
    
    /**
     * Loads user details by username or email.
     * 
     * @param username Username or email of the user
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = findByUsername(username);

        // Check if user with username exists
        if (user == null) {

            // If username does not exist then check if email is passed
            user = findByEmail(username);

            // Check if user with email exists
            if(user == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        }
        return user;
    }

}
