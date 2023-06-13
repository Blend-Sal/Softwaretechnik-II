package com.example.softwaretechnik2;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.softwaretechnik2.controllers.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;


class ProductControllerTest {

    byte[] fileBytes = "Sample file content".getBytes();
    MockMultipartFile file = new MockMultipartFile("image", "sample.jpg", "image/jpeg", fileBytes);


    @Mock
    private ProductRepository repo;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    void testPost() throws Exception {
        // Arrange
        Product newProduct = new Product();
        newProduct.setId(1L);
        MockMultipartFile image = file; // Create a mock MultipartFile with test data
        when(productService.checkIfProductExists(newProduct)).thenReturn(false);

        // Act & Assert
        mockMvc.perform(multipart("/produkterstellung")
                        .file("image", image.getBytes())
                        .flashAttr("product", newProduct))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("product/1"));

        verify(repo, times(1)).save(newProduct);
    }
}
