package com.project.productservice.repositories;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findAllByCategory(Category category);
    void deleteById(Long id);
}
