package com.company.drawing.commands;

import com.company.drawing.exceptions.CommandArgumentsException;

public class CreateCommand implements Command {
    private int width;
    private int height;

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public CreateCommand(String[] args)
    {
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length != 2)
            throw new CommandArgumentsException();

        try {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);

            if(width <= 0 || height <= 0) {
                throw new CommandArgumentsException();
            }

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }
}
