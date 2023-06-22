package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.IOException;
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


    @GetMapping("/productList")

    public String getProd(Model model) {
        List<Product> products = repo.getAllByProductNameIsNotNull();
        model.addAttribute("products", products);
        return "productList";

    }
// Search endpoint to filter products based on the input query
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("query") String query) {
        // Search for products by name using the input query and add them to a new ModelAndView object
        List<Product> products = productService.searchProductByName(query);
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", products);
        // Return the ModelAndView object to render the 'productList' view
        return modelAndView;
    }

    // Search suggestions endpoint to provide autocomplete suggestions based on the input query
    // Basically the 'search' function but instead of returning a modelAndView Object it returns a JSON response.
    @GetMapping("/search-suggestions")
    public ResponseEntity<List<Product>> searchSuggestions(@RequestParam("query") String query) {
        List<Product> products = productService.searchProductByName(query);
        // Return the list of matched products as a JSON response
        return ResponseEntity.ok(products);
    }

    @GetMapping("/produkterstellung")
    public String get(Model model) {
        model.addAttribute("product", new Product());
        return "produkterstellung";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = repo.findProductById(id);
        String base64Image = product.getBase64Image();
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
