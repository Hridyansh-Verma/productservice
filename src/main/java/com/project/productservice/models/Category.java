package com.project.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Category {
    Long id;
    String name;

    public Category(String string) {
        Random random = new Random();
        id= random.nextLong();
        this.name=string;
    }
}
