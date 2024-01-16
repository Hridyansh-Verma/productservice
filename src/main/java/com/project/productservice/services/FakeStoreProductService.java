package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        return product;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,FakeStoreProductDto.class
        );
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addNewProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
