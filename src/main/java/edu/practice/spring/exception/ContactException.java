package edu.practice.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactException extends Exception{
    private String message;
}
