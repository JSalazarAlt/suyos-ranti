package com.suyos.ranti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suyos.ranti.model.Product;
import com.suyos.ranti.service.ProductService;

/**
 * Controller for handling product-related HTTP requests.
 * This controller manages CRUD operations for products including
 * listing, adding, updating, and deleting products.
 * 
 * @author Suyos Team
 * @version 1.0
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    
    /**
     * ProductService instance for product-related operations
     */
    private final ProductService productService;

    /**
     * Constructor for ProductController
     * @param productService ProductService instance for business logic operations
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Displays the list of all products
     * @param model the model to add attributes for the view
     * @return the home view name with products list
     */
    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    /**
     * Shows the form for adding a new product
     * @param model the model to add the new product object
     * @return the product-add view name
     */
    @GetMapping("/showFormForAdd")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-add";
    }

    /**
     * Saves a new or updated product
     * @param product the product object from the form
     * @return redirect to home page
     */
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
       productService.saveProduct(product);
       return "redirect:/";
    }

    /**
     * Shows the form for updating an existing product
     * @param id the ID of the product to update
     * @param model the model to add the product object
     * @return the product-update view name
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    /**
     * Deletes a product by its ID
     * @param id the ID of the product to delete
     * @return redirect to home page
     */
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/";
    }

}
