package com.company.drawing.commands;

import com.company.drawing.exceptions.CommandInvalidException;

import java.util.Arrays;

public class CommandFactory {

    static public class CommandParams
    {
        public CommandParams(String command, String[] args)
        {
            this.command = command;
            this.args = args;
        }

        public String command;
        public String[] args;
    }

    public static CommandParams parse(String rawInput)
    {
        String[] cmdArgs = rawInput.split("\\W+");
        String[] args = Arrays.copyOfRange(cmdArgs, 1, cmdArgs.length);
        return new CommandParams(cmdArgs[0], args);
    }

    public Command getCommand(String commandline) {
        CommandParams commandParams = parse(commandline);
        switch (commandParams.command) {
            case "C":
                return new CreateCommand(commandParams.args);
            case "L":
                return new LineCommand(commandParams.args);
            case "R":
                return new RectangleCommand(commandParams.args);
            case "B":
                return new FillCommand(commandParams.args);
            case "Q":
                return new ExitCommand();
            default:
                throw new CommandInvalidException();
        }
    }
}
