package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController extends Product {
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;
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

    @PostMapping("/produkterstellung")
    public String post(@ModelAttribute Product newProduct) {
        if (productService.checkIfProductExists(newProduct)) {
            return "errorDuplicateProduct";
        } else {
            repo.save(newProduct);
            return "produkterstellung";
        }
    }

//    //@GetMapping("/produkterstellung")
//    public String showAddProductForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "add-product";
//    }
//
//    //@PostMapping("/products")
//    public String addProduct(@ModelAttribute("product") Product product) {
//        productList.add(product);
//        return "redirect:/product-list";
//    }
//
//    //@GetMapping("/product-list")
//    public String showProductList(Model model) {
//        model.addAttribute("products", productList);
//        return "product-list";
//    }
}