package com.company.drawing.commands;

import com.company.drawing.canvas.Canvas;

public class CreateCommand implements Command {
    private Canvas canvas;
    private int width;
    private int height;

    public CreateCommand(Canvas canvas, String[] args)
    {
        this.canvas = canvas;
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length < 2)
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

    public void execute()
    {
        canvas.init(width, height);
    }

}
