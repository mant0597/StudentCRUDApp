package com.example.learningSpringBoot;

public class StudentNotFoundException  extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
