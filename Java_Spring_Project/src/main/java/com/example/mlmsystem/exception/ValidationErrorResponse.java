package com.example.mlmsystem.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

//ValidationErrorResponse.java
public class ValidationErrorResponse extends ErrorResponse {
 private List<String> errors;

 public ValidationErrorResponse(BindingResult result) {
     super("Validation failed");
     this.errors = result.getFieldErrors().stream()
             .map(error -> error.getField() + ": " + error.getDefaultMessage())
             .collect(Collectors.toList());
 }

 // Getter
}