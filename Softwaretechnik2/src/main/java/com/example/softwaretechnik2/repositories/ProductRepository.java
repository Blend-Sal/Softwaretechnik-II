package com.example.softwaretechnik2.repositories;


import com.example.softwaretechnik2.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findProductsByCategory(String category);
    public Product findProductById(Long id);
    public Product findProductByProductName(String productName);
    @Transactional
    public void deleteProductByProductName(String s);
}