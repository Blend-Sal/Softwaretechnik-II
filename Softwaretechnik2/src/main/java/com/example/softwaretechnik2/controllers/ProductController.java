package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController extends Product {

    // Autowired dependencies for product-related operations
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;
    @Autowired
    private ServletContext servletContext;

    // GET mapping for the list of products
    @GetMapping("/productList")
    public String getProd(Model model) {
        List<Product> products = repo.getAllByProductNameIsNotNull();
        model.addAttribute("products", products);
        return "productList";
    }

    // GET mapping for the product creation form
    @GetMapping("/produkterstellung")
    public String get(Model model) {
        model.addAttribute("product", new Product());
        return "produkterstellung";
    }

    // GET mapping for a specific product's details
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = repo.findProductById(id);
        String base64Image = product.getBase64Image();
        model.addAttribute("Image", base64Image);
        model.addAttribute("product", product);
        return "detailsofproduct";
    }

    // POST mapping for saving the new product
    @PostMapping("/produkterstellung")
    public String post(@ModelAttribute Product newProduct, BindingResult result,
                       @RequestParam("image") MultipartFile image) throws IOException {
        // Check if the product already exists
        if (productService.checkIfProductExists(newProduct)) {
            return "errorDuplicateProduct";
        }

        // Save the image and product
        byte[] imageBytes = image.getBytes();
        newProduct.setImage(imageBytes);
        repo.save(newProduct);

        // Redirect to the product's details page
        return "redirect:product/" + newProduct.getId();
    }
}
