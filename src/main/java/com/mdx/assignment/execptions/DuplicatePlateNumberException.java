package com.mdx.assignment.execptions;

public class DuplicatePlateNumberException extends RuntimeException {
    public DuplicatePlateNumberException(String message) {
        super(message);
    }
}
