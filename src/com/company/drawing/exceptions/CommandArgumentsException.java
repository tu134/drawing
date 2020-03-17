package com.company.drawing.exceptions;

public class CommandArgumentsException extends RuntimeException {
    public CommandArgumentsException() {
        super("invalid arguments for command");
    }
}
