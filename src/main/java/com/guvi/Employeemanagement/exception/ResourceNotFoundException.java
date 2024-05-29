package com.guvi.Employeemanagement.exception;

import jakarta.persistence.Entity;

import java.io.Serial;

@Entity
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

