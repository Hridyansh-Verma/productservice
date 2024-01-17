package com.project.productservice.controlleradvices;

import com.project.productservice.dtos.ExceptionDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(ProductNotFoundException productNotFoundException)
    {
        ExceptionDto exceptionDto= new ExceptionDto();
        exceptionDto.setMessage("Exceptionnnnnn");
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        ExceptionDto exceptionDto= new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }
}
