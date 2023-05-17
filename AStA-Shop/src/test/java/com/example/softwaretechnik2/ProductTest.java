package com.example.softwaretechnik2;

import com.example.softwaretechnik2.Product.Product;
import com.example.softwaretechnik2.Product.ProductRepository;
import com.example.softwaretechnik2.Product.ProductService;
import  org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository repo;
    @BeforeEach
    void setUp() {
        //Reihenfolge wichtig
        Product banane = new Product();
        banane.setCategory("Obst");

        Product kakao = new Product();
        kakao.setCategory("Getränk");
        kakao.setProductName("Kakao");

        Product kaffee2go = new Product();
        kaffee2go.setCategory("Getränk");

        Product salamibrötchen = new Product();
        salamibrötchen.setCategory("Belegtes Brötchen");

        Product kakao2 = new Product();
        kakao2.setCategory("Getränk");
        kakao2.setProductName("Kakao");

        repo.save(banane);
        repo.save(kakao);
        repo.save(kaffee2go);
        repo.save(salamibrötchen);
        repo.save(kakao2);
    }

    @Test
    public void shouldSaveUser() {
        Product product = new Product();
        Product savedProduct = repo.save(product);
        assertTrue(product.equals(savedProduct));
        repo.delete(product);
    }
    @Test
    void testFindProductsByCategory() {
        List<Product> getränke = repo.findProductsByCategory("Getränk");
        Stream<Product> getränkeStream = getränke.stream();
        assertTrue(getränkeStream.allMatch(x -> x.getCategory().equals("Getränk")));
    }
    @Test
    void testInitialProductNotBought() {
        Product product = new Product();
        assertFalse(repo.findProductById(4L).isBought());
        repo.delete(product);
    }
    @Test
    void testAutoGeneratedProductID() {
        assertEquals(4L, repo.findProductsByCategory("Belegtes Brötchen").get(0).getId());
    }
    @Test
    void testProductIsBought() {
        productService.buyProduct(repo.findProductById(1L));
        assertTrue(repo.findProductById(1L).isBought());
    }

    @Test
    void testFindProductsByName() {
        List<Product> kakaos = repo.findProductsByProductName("Kakao");
        Stream<Product> kakaoStream = kakaos.stream();
        assertTrue(kakaoStream.allMatch(x -> x.getProductName().equals("Kakao")));
    }
}
