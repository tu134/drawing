package com.company.drawing.commands;

import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Rectangle;
import com.company.drawing.exceptions.CommandArgumentsException;

public class RectangleCommand implements DrawCommand {
    private Rectangle rectangle;

    public RectangleCommand(String[] args)
    {
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length != 4)
            throw new CommandArgumentsException();

        try {
            int x1 = Integer.parseInt(args[0]);
            int y1 = Integer.parseInt(args[1]);
            int x2 = Integer.parseInt(args[2]);
            int y2 = Integer.parseInt(args[3]);

            rectangle = new Rectangle(x1, y1, x2, y2);

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }

    @Override
    public Drawable getDrawable() {
        return rectangle;
    }
}