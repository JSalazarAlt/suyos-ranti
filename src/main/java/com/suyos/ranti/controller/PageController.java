package com.suyos.ranti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for handling general page navigation requests.
 * This controller manages the routing for static pages like home, login, and terms.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Controller
public class PageController {
    
    /**
     * Displays the home (index) page
     * @return the index view name
     */
    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    /**
     * Displays the login page
     * @param redirectAttributes attributes for flash messages
     * @return the login view name
     */
    @GetMapping("/login")
    public String showLoginPage(RedirectAttributes redirectAttributes) {
        return "login";
    }

    /**
     * Displays the terms and conditions page
     * @return the terms view name
     */
    @GetMapping("/terms")
    public String showTermsPage() {
        return "terms";
    }

}
