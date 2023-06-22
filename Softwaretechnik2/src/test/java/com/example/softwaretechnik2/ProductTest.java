package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Availability;
import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        // Set up test data
        // Order is important
        Product banane = new Product();
        banane.setCategory("Obst");

        Product kakao = new Product();
        kakao.setCategory("Getränk");
        kakao.setProductName("Kakao");

        Product kaffee2go = new Product();
        kaffee2go.setCategory("Getränk");

        Product salamibroetchen = new Product();
        salamibroetchen.setCategory("Belegtes Brötchen");

        // Save test data to the repository
        repo.save(banane);
        repo.save(kakao);
        repo.save(kaffee2go);
        repo.save(salamibroetchen);
    }

    // Test cases

    @Test
    public void shouldSaveProduct() {
        // Test saving a product
        Product product = new Product();
        Product savedProduct = repo.save(product);
        assertEquals(product, savedProduct);
        repo.delete(product);
    }

    @Test
    void testFindProductsByCategory() {
        // Test finding products by category
        List<Product> getraenke = repo.findProductsByCategory("Getränk");
        Stream<Product> getraenkeStream = getraenke.stream();
        assertTrue(getraenkeStream.allMatch(x -> x.getCategory().equals("Getränk")));
    }

    @Test
    void testInitialProductNotBought() {
        // Test if a newly created product is not marked as bought
        Product product = new Product();
        assertFalse(repo.findProductById(4L).isBought());
        repo.delete(product);
    }

    @Test
    void testAutoGeneratedProductID() {
        // Test if the product ID is auto-generated correctly
        assertEquals(4L, repo.findProductsByCategory("Belegtes Brötchen").get(0).getId());
    }

    @Test
    void testProductIsBought() {
        // Test if a product is marked as bought after buying
        productService.buyProduct(repo.findProductById(1L));
        assertTrue(repo.findProductById(1L).isBought());
    }

    @Test
    void testFindProductByName() {
        // Test finding a product by name
        Product product = new Product();
        product.setProductName("Hans");
        repo.save(product);
        Product hans = repo.findProductByProductName("Hans");
        assertEquals(hans.getProductName(), "Hans");
        repo.delete(product);
    }

    @Test
    void exceedInputsetproductName() {
        // Test if the setProductName method returns false when the input exceeds the limit
        Product test = new Product();
        assertFalse(test.setProductName("12345"));
    }

    @Test
    void exceedInputsetCategory() {
        // Test if the setCategory method returns false when the input exceeds the limit
        Product test = new Product();
        assertFalse(test.setCategory("12345"));
    }

    @Test
    void onlyNumbersInput() {
        // Test if the setId method accepts only numbers
        Product test = new Product();
        assertTrue(test.setId(1L));
    }

    @Test
    void onlyNumbersinputsetPrice() {
        // Test if the setPrice method accepts only numbers
        Product test = new Product();
        assertTrue(test.setPrice(3.01f));
    }

    @Test
    void onlyStringInputSetIngredients() {
        // Test if the setIngredients method accepts only strings
        Product test = new Product();
        String ingredients = "Salamibrötchen, Schokobrötchen";
        assertTrue(test.setIngredients(ingredients));
    }

    @Test
    void isKoshertest() {
        // Test if the isKosher method returns the correct value
        Product test = new Product();
        assertFalse(test.isKosher());

        test.setKosher(true);
        assertTrue(test.isKosher());

        test.setKosher(false);
        assertFalse(test.isKosher());
    }

    @Test
    void availabilitySavedAsString() {
        // Test if the availability is saved as a string
        Product test = new Product();
        test.setAvailability(Availability.FULL);
        repo.save(test);
        assertEquals("Voll", test.getAvailability());
        repo.delete(test);
    }

    @Test
    void properAvailabilityDisplayName() {
        // Test if the availability display name is correct
        Availability a = Availability.FULL;
        assertEquals("Voll", a.getDisplayValue());
    }


    @Test
    void testDeleteByProductName() {
        // Test if a product is deleted by its name
        Product milch = new Product();
        milch.setProductName("Milch");
        repo.save(milch);
        repo.deleteProductByProductName("Milch");
        assertNull(repo.findProductByProductName("Milch"));
    }

    @Test
    void testCheckIfProductAlreadyExists() {
        // Test if a product already exists in the repository
        Product p1 = new Product();
        p1.setProductName("Mehl");
        repo.save(p1);
        assertTrue(productService.checkIfProductExists(p1));
    }

    @Test
    void getCategoryTest() {
        // Test if the getCategory method returns the correct category
        Product product = new Product();
        String test = "Getränk";
        product.setCategory(test);
        assertEquals(test, product.getCategory());
    }

    @Test
    void getIdTest() {
        // Test if the getId method returns the correct ID
        Product product = new Product();
        long id = 1L;
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    void getProductNameTest() {
        // Test if the getProductName method returns the correct name
        Product product = new Product();
        String name = "Salamibrötchen";
        product.setProductName(name);
        assertEquals(name, product.getProductName());
    }

    @Test
    void getAllergensTest() {
        // Test if the getAllergens method returns the correct allergens
        Product product = new Product();
        String allergens = "Laktose Intolerant";
        product.setAllergens(allergens);
        assertEquals(allergens, product.getAllergens());
    }

    @Test
    void getIngredientsTest() {
        // Test if the getIngredients method returns the correct ingredients
        Product product = new Product();
        String ingredient = "Milch";
        product.setIngredients(ingredient);
        assertEquals(ingredient, product.getIngredients());
    }

    @Test
    void getPriceTest() {
        // Test if the getPrice method returns the correct price
        Product product = new Product();
        float price = 2.0f;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void setVeganTest() {
        // Test if the setVegan method sets the correct value
        Product product = new Product();
        product.setVegan(true);
        assertTrue(product.isVegan());
        product.setVegan(false);
        assertFalse(product.isVegan());
    }

    @Test
    void isEqualToTest() {
        // Test if the isEqualTo method correctly compares two products
        Product product = new Product();
        Product product1 = new Product();
        Product product2 = new Product();
        product.setProductName("Salamibrötchen");
        product1.setProductName("Salamibrötchen");
        product2.setProductName("Schokobrötchen");
        assertTrue(product.isEqualTo(product1));
        assertFalse(product2.isEqualTo(product));
    }

    @Test
    void setVegetarian() {
        // Test if the setVegetarian method sets the correct value
        Product product = new Product();
        Product product1 = new Product();
        product.setVegetarian(true);
        assertTrue(product.isVegetarian());
        assertFalse(product1.isVegetarian());
    }

    @Test
    void setHalal() {
        // Test if the setHalal method sets the correct value
        Product product = new Product();
        Product product1 = new Product();
        product.setHalal(true);
        product1.setHalal(false);
        assertTrue(product.isHalal());
        assertFalse(product1.isHalal());
    }

    @Test
    void isBoughtTest() {
        // Test if the isBought method returns the correct value
        Product product = new Product();
        Product product1 = new Product();
        product.setBought(true);
        product1.setBought(false);
        assertTrue(product.isBought());
        assertFalse(product1.isBought());
    }

    @Test
    void base64ImageTest() {
        // Test if the base64Image method returns the correct base64 image string
        byte[] imageBytes = new byte[]{(byte) 0x89, (byte) 0x50, (byte) 0x4E, (byte) 0x47,
                (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};
        Product myClass = new Product();
        myClass.setImage(imageBytes);
        String expectedBase64Image = "iVBORw0KGgo=";
        assertEquals(expectedBase64Image, myClass.getBase64Image());


    }
}
