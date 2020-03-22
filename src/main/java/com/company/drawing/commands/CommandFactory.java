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
                return new LineCommand(args);
            case "R":
                return new RectangleCommand(args);
            case "B":
                return new FillCommand(args);
            case "Q":
                return new ExitCommand();
            default:
                throw new CommandInvalidException();
        }
    }
}
