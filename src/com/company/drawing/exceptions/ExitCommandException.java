package com.company.drawing.exceptions;

public class ExitCommandException extends RuntimeException {
    public ExitCommandException() {
        super("exit command exception");
    }
}
