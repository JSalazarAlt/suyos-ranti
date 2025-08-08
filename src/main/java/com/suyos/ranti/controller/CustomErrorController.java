package com.suyos.ranti.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Custom error controller for handling application errors.
 * This controller provides user-friendly error handling by redirecting
 * users to appropriate pages based on their authentication status.
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Handles all application errors and redirects users appropriately
     * @param request the HTTP request that caused the error
     * @param redirectAttributes attributes for flash messages
     * @return ModelAndView with redirect to dashboard or login based on authentication
     */
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() ) {
            redirectAttributes.addFlashAttribute("errorMessage","Redirected to Dashboard due to issue!");
            return new ModelAndView("redirect:/products");
        }
        return new ModelAndView("redirect:/login");
    }

    /**
     * Returns the error path for this controller
     * @return the error path string
     */
    public String getErrorPath() {
        return "/error";
    }
}
