package com.company.drawing.exceptions;

public class CommandInvalidException extends RuntimeException {
    public CommandInvalidException() {
        super("invalid command");
    }
}
