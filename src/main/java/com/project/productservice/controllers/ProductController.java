package com.project.productservice.controllers;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import com.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private RestTemplate restTemplate;
    private ProductService productService;
    @Autowired
    public ProductController(RestTemplate restTemplate, ProductService productService) {
        this.restTemplate = restTemplate;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")Long id)
    {
        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.ACCEPTED);
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.ACCEPTED);
    }
    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.addNewProduct(product),HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.replaceProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
    }
    @GetMapping("/category/{category}")
    public List<Product> getAllCategories(@PathVariable("category") String category)
    {
        return productService.getProductsOfCategory(category);
    }
}
