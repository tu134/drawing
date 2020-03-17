package com.company.drawing.commands;

public class CommandInvalidException extends RuntimeException {
    public CommandInvalidException() {
        super("invalid command");
    }
}
