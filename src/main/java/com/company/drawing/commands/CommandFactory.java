package com.company.drawing.commands;

import com.company.drawing.exceptions.CommandInvalidException;

import java.util.Arrays;

public class CommandFactory {

    public Command getCommand(String commandline) {
        String[] args = commandline.split("\\s+");
        String command = args[0];
        args = Arrays.copyOfRange(args, 1, args.length);

        switch (command) {
            case "C":
                return new CreateCommand(args);
            case "L":
            case "R":
            case "B":
                return new DrawCommand(command, args);
            case "Q":
                return new ExitCommand();
            default:
                throw new CommandInvalidException();
        }
    }
}
