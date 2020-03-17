package com.company.drawing.commands;

import com.company.drawing.drawables.Rectangle;
import com.company.drawing.canvas.Canvas;
import com.company.drawing.exceptions.CommandArgumentsException;

public class RectangleCommand implements Command {
    private Canvas canvas;
    private Rectangle rectangle;

    public RectangleCommand(Canvas canvas, String[] args)
    {
        this.canvas = canvas;
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length != 4)
            throw new CommandArgumentsException();

        try {
            int x1 = Integer.parseInt(args[0]);
            int y1 = Integer.parseInt(args[1]);
            int x2 = Integer.parseInt(args[2]);
            int y2 = Integer.parseInt(args[3]);

            if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
                throw new CommandArgumentsException();
            }

            rectangle = new Rectangle(x1, y1, x2, y2);

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }

    public void execute()
    {
        rectangle.draw(canvas);
    }

}