package edu.practice.spring.exception;

import lombok.Data;

@Data
public class ValidationError {
    private String field;
    private Object rejectedValue;
    private String message;
}
