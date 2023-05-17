package com.example.softwaretechnik2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;

    @GetMapping("/login")
    public String login(Model model) {
        //Optional<Product> product = repo.findById(1L);
        //model.addAttribute("salamibrötchen",product.get().getProductName());

        return "login";
    }
}