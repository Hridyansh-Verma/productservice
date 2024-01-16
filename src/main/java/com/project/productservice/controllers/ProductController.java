package com.project.productservice.controllers;

import com.project.productservice.models.Product;
import com.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Product getProduct(@PathVariable("id")Long id)
    {
        return productService.getSingleProduct(id);
    }
    @GetMapping("/all")
    public List<Product> getAllProducts() { return productService.getAllProducts();}
    @PostMapping("/{id}")
    public Product addNewProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.addNewProduct(id,product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }
    @PatchMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.replaceProduct(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProduct(id);
    }
}
