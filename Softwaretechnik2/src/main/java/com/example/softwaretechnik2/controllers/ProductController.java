package com.example.softwaretechnik2.controllers;

import com.example.softwaretechnik2.model.Availability;
import com.example.softwaretechnik2.model.Product;
import com.example.softwaretechnik2.repositories.ProductRepository;
import com.example.softwaretechnik2.services.ProductService;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController extends Product {

    // Autowired dependencies for product-related operations
    @Autowired
    ProductRepository repo;
    @Autowired
    ProductService productService;
    @Autowired
    private ServletContext servletContext;

    // GET mapping for the list of products
    @GetMapping("/productList")
    public String getProd(Model model) {
        List<Product> products = repo.getAllByProductNameIsNotNull();
        model.addAttribute("products", products);
        return "productList";
    }

    // Search endpoint to filter products based on the input query
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("query") String query) {
        // Search for products by name using the input query and add them to a new ModelAndView object
        List<Product> products = productService.searchProductByName(query);
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", products);
        // Return the ModelAndView object to render the 'productList' view
        return modelAndView;
    }

    // Search suggestions endpoint to provide autocomplete suggestions based on the input query
    // Basically the 'search' function but instead of returning a modelAndView Object it returns a JSON response.
    @GetMapping("/search-suggestions")
    public ResponseEntity<List<Product>> searchSuggestions(@RequestParam("query") String query) {
        List<Product> products = productService.searchProductByName(query);
        // Return the list of matched products as a JSON response
        return ResponseEntity.ok(products);
    }


    // GET mapping for the product creation form
    @GetMapping("/produkterstellung")
    public String get(Model model) {
        model.addAttribute("product", new Product());
        return "produkterstellung";
    }

    // TODO Die implementierung von Shopinformation hier übernehmen
    // GET mapping for a specific product's details
    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = repo.findProductById(id);
        String base64Image = product.getBase64Image();
        model.addAttribute("Image", base64Image);
        model.addAttribute("product", product);
        // Add the existing shop information or a new one to the model
        model = model.addAttribute("DetailsOfProduct", product);

        // Add the "editing" attribute to the model if it's not present
        if (!model.containsAttribute("editing")) {
            model.addAttribute("editing", false);
        }
        return "detailsofproduct";
    }

    // POST mapping for saving the new product
    @PostMapping("/produkterstellung")
    public String post(@ModelAttribute Product newProduct, BindingResult result,
                       @RequestParam("image") MultipartFile image) throws IOException {
        // Check if the product already exists
        if (productService.checkIfProductExists(newProduct)) {
            return "errorDuplicateProduct";
        }

        // Save the image and product
        byte[] imageBytes = image.getBytes();
        newProduct.setImage(imageBytes);
        repo.save(newProduct);

        // Redirect to the product's details page
        return "redirect:product/" + newProduct.getId();
    }

    @PostMapping("/detailsofproduct/{id}/edit")
    public String editDetailsofproductInformation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("editing", true);
        return "redirect:/product/" + id;
    }


    @PostMapping("/detailsofproduct/{id}")
    public String saveEditedProduct(@PathVariable Long id, @ModelAttribute Product editedProduct, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
        System.out.println("newproduct:" + editedProduct);
        Product existingProduct = repo.findProductById(id);
        existingProduct = productService.updateProductDetails(existingProduct, editedProduct);

        // Save the edited product
        System.out.println("tobeinserted:" + existingProduct);
        repo.save(existingProduct);

        // Redirect to the product's details page
        return "redirect:/product/" + editedProduct.getId();
    }

}
