package com.suyos.ranti.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.suyos.ranti.model.User;
import com.suyos.ranti.service.UserService;

/**
 * Controller for handling user profile operations.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Controller
public class UserController {

    /**
     * UserService instance for user-related operations
     */
    private UserService userService;
    
    /**
     * Password encoder for encrypting user passwords
     */
    private PasswordEncoder passwordEncoder;
    
    /**
     * Displays the change password page
     * @return the change password view
     */
    @GetMapping("/changepasswd")
    public String getChangePassword() {
        return "changepasswd";
    }

    /**
     * Handles password change requests
     * @param currentPassword the user's current password
     * @param newPassword the new password to set
     * @param redirectAttributes attributes for flash messages
     * @return redirect to dashboard
     */
    @PostMapping("/changepasswd")
    public String changePassword(String currentPassword, String newPassword, RedirectAttributes redirectAttributes) {
        User user = userService.getCurrentUser();
        
        if (!isValidPasswordChange(user, currentPassword)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Current password is incorrect");
            return "redirect:/dashboard";
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userService.save(user);

        redirectAttributes.addFlashAttribute("successMessage", "Password updated successfully");
        return "redirect:/dashboard";
    }
    
    /**
     * Validates if the password change request is valid
     * @param user the user attempting to change password
     * @param currentPassword the provided current password
     * @return true if valid, false otherwise
     */
    private boolean isValidPasswordChange(User user, String currentPassword) {
        return user != null && passwordEncoder.matches(currentPassword, user.getPassword());
    }
}
