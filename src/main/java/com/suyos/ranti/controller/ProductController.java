package com.suyos.ranti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

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
    @GetMapping()
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    /**
     * Shows the form for adding a new product
     * @param model the model to add the new product object
     * @return the product-add view name
     */
    @GetMapping("/new")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-add";
    }

    /**
     * Saves a new or updated product with image upload
     * @param product the product object from the form
     * @param imageFile the uploaded image file
     * @return redirect to products page
     */
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product, 
                            @RequestParam("imageFile") MultipartFile imageFile) {
        
        // Handle image upload
        if (!imageFile.isEmpty()) {
            try {
                // Validate file size (5MB)
                if (imageFile.getSize() > 5 * 1024 * 1024) {
                    // Handle error - file too large
                    return "redirect:/products/new?error=filesize";
                }
                
                // Create uploads directory if it doesn't exist
                String uploadDir = "src/main/resources/static/uploads/";
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                
                // Generate unique filename
                String originalFilename = imageFile.getOriginalFilename();
                
                if (originalFilename != null && originalFilename.contains(".")) {
                    String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

                    // Save file
                    Path filePath = uploadPath.resolve(uniqueFilename);
                    Files.copy(imageFile.getInputStream(), filePath);

                    // Set the image URL in the product
                    product.setImgUrl("/uploads/" + uniqueFilename);
                } else {
                    // Handle error - invalid file name
                    return "redirect:/products/new?error=filename";
                }
            } catch (IOException e) {
                // Handle file upload error
                return "redirect:/products/new?error=upload";
            }
        }
        
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * Shows the form for updating an existing product
     * @param id the ID of the product to update
     * @param model the model to add the product object
     * @return the product-update view name
     */
    @GetMapping("/{id}/edit")
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
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

}
