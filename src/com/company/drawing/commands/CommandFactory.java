package com.company.drawing.commands;

import com.company.drawing.canvas.Canvas;
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

    private Canvas canvas;

    public CommandFactory(Canvas canvas) {
        this.canvas = canvas;
    }

    public static CommandParams parse(String rawInput)
    {
        var cmdArgs = rawInput.split("\\W+");
        if(cmdArgs.length < 1) return null;
        String[] args = Arrays.copyOfRange(cmdArgs, 1, cmdArgs.length);
        return new CommandParams(cmdArgs[0], args);
    }

    public Command getCommand(String commandline) {
        CommandParams commandParams = parse(commandline);
        if(commandParams == null) return null;
        switch (commandParams.command) {
            case "C":
                return new CreateCommand(canvas, commandParams.args);
            case "L":
                return new LineCommand(canvas, commandParams.args);
            case "R":
                return new RectangleCommand(canvas, commandParams.args);
            case "B":
                return new FillCommand(canvas, commandParams.args);
            case "Q":
                return new ExitCommand();
            default:
                throw new CommandInvalidException();
        }
    }
}
