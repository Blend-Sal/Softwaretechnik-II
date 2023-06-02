package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController extends Product {
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;
    @Autowired
    private ServletContext servletContext;

    @GetMapping("/product")
    public String getProd(Model model) {
        List<Product> products = repo.getAllByProductNameIsNotNull();
        model.addAttribute("products", products);
        return "productList";

    }

    @GetMapping("/produkterstellung")
    public String get(Model model) {
        model.addAttribute("product", new Product());
        return "produkterstellung";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = repo.findProductById(id);
        byte[] imageData = product.getImage();
        String base64Image = Base64.getEncoder().encodeToString(imageData);
        model.addAttribute("Image", base64Image);
        model.addAttribute("product", product);
        return "detailsofproduct";
    }

    //optimal image resolution is about 400x400 -> implement resize?
    @PostMapping("/produkterstellung")
    public String post(@ModelAttribute Product newProduct, BindingResult result, @RequestParam("image") MultipartFile image) throws IOException {
        System.out.println("here");
        if (productService.checkIfProductExists(newProduct)) {
            return "errorDuplicateProduct";
        }
        byte[] imageBytes = image.getBytes();
        newProduct.setImage(imageBytes);
        repo.save(newProduct);
        return "redirect:product/" + newProduct.getId();
    }
}