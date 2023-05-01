package com.example.softwaretechnik2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class DemoController {
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String demo(Model model) {
        Product salamibrötchen = new Product();
        salamibrötchen.setProductName("Salamibrötchen");

        productService.addProduct(salamibrötchen);

        Optional<Product> product = repo.findById(1L);
        model.addAttribute("salamibrötchen",product.get().getProductName());

        return "demo";
    }
}