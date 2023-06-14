package com.example.softwaretechnik2.repositories;


import com.example.softwaretechnik2.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Find products by their category
    public List<Product> findProductsByCategory(String category);

    // Find all products with a non-null product name
    List<Product> getAllByProductNameIsNotNull();

    // Find a product by its ID
    public Product findProductById(Long id);

    // Find a product by its name
    public Product findProductByProductName(String productName);

    // Delete a product by its name
    @Transactional
    public void deleteProductByProductName(String s);
}
