package com.project.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

    String name;
    public Category(String string) {
        Random random = new Random();
        id= random.nextLong();
        this.name=string;
    }
    public Category() {

    }
}
