package com.project.productservice.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
