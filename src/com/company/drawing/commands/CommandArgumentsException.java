package com.company.drawing.commands;

public class CommandArgumentsException extends RuntimeException {
    public CommandArgumentsException() {
        super("invalid arguments for command");
    }
}
