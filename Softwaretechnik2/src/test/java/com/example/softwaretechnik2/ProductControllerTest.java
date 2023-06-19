package com.example.softwaretechnik2;

import com.example.softwaretechnik2.controllers.ProductController;
import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ProductControllerTest {

    // Initialize test data
    byte[] fileBytes = "Sample file content".getBytes();
    MockMultipartFile file = new MockMultipartFile("image", "sample.jpg", "image/jpeg", fileBytes);

    // Create mocks for dependencies
    @Mock
    private ProductRepository repo;

    @Mock
    private ProductService productService;

    // Inject mocks into the controller
    @InjectMocks
    private ProductController productController;

    // Initialize the mockMvc for testing
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        // Set up the mocks and the mockMvc
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testPost() throws Exception {
        // Create a new test product
        Product newProduct = new Product();
        newProduct.setId(1L);
        MockMultipartFile image = file;

        // Set up the productService mock to return false when checking if the product exists
        when(productService.checkIfProductExists(newProduct)).thenReturn(false);

        // Perform the POST request to the "/produkterstellung" endpoint with the test product and image
        mockMvc.perform(multipart("/produkterstellung")
                        .file("image", image.getBytes())
                        .flashAttr("product", newProduct))
                // Expect a 3xx redirection status
                .andExpect(status().is3xxRedirection())
                // Expect the redirection URL to be "product/1"
                .andExpect(redirectedUrl("product/1"));

        // Verify that the save method was called once with the new product
        verify(repo, times(1)).save(newProduct);
    }
}


