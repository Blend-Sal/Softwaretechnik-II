package com.example.softwaretechnik2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public void buyProduct(Product product) {
        product.setBought(true);
        repo.save(product);
    }
}
