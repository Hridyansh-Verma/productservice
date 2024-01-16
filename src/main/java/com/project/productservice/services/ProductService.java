package com.project.productservice.services;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product getSingleProduct(Long id) ;

    List<Product> getAllProducts();

    Product addNewProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getProductsOfCategory(String category);
}
