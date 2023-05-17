package com.example.softwaretechnik2.Product;

import com.example.softwaretechnik2.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController extends Product {
    @Autowired
    ProductRepository repo;
    private List<Product> productList = new ArrayList<>();

    @GetMapping("/produktseite")
    public String getProd() {
        return "produktseite";
    }
    @GetMapping("/produkterstellung")
    public String get() {
        return "produkterstellung";
    }

    @PostMapping("/produkterstellung")
    public String post(@ModelAttribute Product newProduct) {
        repo.save(newProduct);
        return "produkterstellung";
        // TODO
        // Verfügbarkeit enum eingabe
        // Inhaltsstoffe aus Liste auswählen können
        // Zugriif auf die Seite nur mit Mitarbeiterrechte
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