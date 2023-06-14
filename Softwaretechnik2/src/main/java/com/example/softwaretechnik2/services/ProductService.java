package com.example.softwaretechnik2.services;

import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    // Autowired ProductRepository for database access
    @Autowired
    ProductRepository repo;

    // Buy a product and save it to the repository
    public void buyProduct(Product product) {
        product.setBought(true);
        repo.save(product);
    }

    // Check if a product exists in the repository
    public boolean checkIfProductExists(Product product) {
        for (Product p : repo.findAll()) {
            if (product.isEqualTo(p)) {
                return true;
            }
        }
        return false;
    }
}


