package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Availability;
import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest extends Product {

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

        repo.save(banane);
        repo.save(kakao);
        repo.save(kaffee2go);
        repo.save(salamibrötchen);
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
    void testFindProductByName() {
        Product product = new Product();
        product.setProductName("Hans");
        repo.save(product);
        Product hans = repo.findProductByProductName("Hans");
        assertEquals(hans.getProductName(), "Hans");
        repo.delete(product);
    }

    @Test
    void exceedInputsetproductName() {
        Product test = new Product();
        assertFalse(test.setProductName("12345"));
    }

    @Test
    void exceedInputsetCategory() {
        Product test = new Product();
        assertFalse(test.setCategory("12345"));
    }

    @Test
    void onlyNumbersInput() {
        Product test = new Product();
        assertTrue(test.setId(1L));
    }


    @Test
    void onlyNumbersinputsetPrice() {
        Product test = new Product();
        assertTrue(test.setPrice(3.01f));
    }

    @Test
    void onlyStringInputSetIngredients() {
        Product test = new Product();
        List<String> ingredients = Arrays.asList("Salamibrötchen", "Schokobrötchen");
        assertTrue(test.setIngredients(ingredients));
    }

    @Test
    void isKoshertest() {
        Product test = new Product();
        assertFalse(test.isKosher());

        test.setKosher(true);
        assertTrue(test.isKosher());

        test.setKosher(false);
        assertFalse(test.isKosher());
    }

    /* outdated, image is now stored as byte[]
    @Test
    void imageTest() {
        Product product = new Product();
        String expectedImage = "example_image.jpg";
        product.setImage(expectedImage);
        String actualImage = product.getImage();
        assertEquals(expectedImage, actualImage);
    }*/


    @Test
    void availabilitySavedAsString() {
        Product test = new Product();
        test.setAvailability(Availability.FULL);
        repo.save(test);
        assertEquals("Full", test.getAvailability());
        repo.delete(test);
    }

    @Test
    void properAvailabilityDisplayName() {
        Availability a = Availability.FULL;
        assertEquals("Full", a.getDisplayValue());
    }

    @Test
    void testDeleteByProductName() {
        Product milch = new Product();
        milch.setProductName("Milch");
        repo.save(milch);
        repo.deleteProductByProductName("Milch");
        assertNull(repo.findProductByProductName("Milch"));
    }

    @Test
    void testCheckIfProductAlreadyExists() {
        Product p1 = new Product();
        p1.setProductName("Mehl");
        repo.save(p1);
        assertTrue(productService.checkIfProductExists(p1));
    }
}