package com.project.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    String title;
    String description;
    Double price;
    String imageUrl;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    Category category;
}
