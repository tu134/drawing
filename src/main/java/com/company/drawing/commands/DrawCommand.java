package com.company.drawing.commands;

import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Fill;
import com.company.drawing.drawables.Line;
import com.company.drawing.drawables.Rectangle;
import com.company.drawing.exceptions.CommandArgumentsException;
import com.company.drawing.exceptions.CommandInvalidException;

public class DrawCommand implements Command {
    private Drawable drawable;

    public DrawCommand(String command, String[] args) {
        switch (command) {
            case "L":
                initLine(args);
                break;
            case "R":
                initRectangle(args);
                break;
            case "B":
                initFill(args);
                break;
            default:
                throw new CommandInvalidException();
        }
    }

    private void initLine(String[] args)
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

            drawable = new Line(x1, y1, x2, y2);

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }

    private void initRectangle(String[] args)
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

            drawable = new Rectangle(x1, y1, x2, y2);

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }

    private void initFill(String[] args)
    {
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length != 3)
            throw new CommandArgumentsException();

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int color = args[2].charAt(0);

            drawable = new Fill(x, y, color);

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new CommandArgumentsException();
        }
    }

    public Drawable getDrawable() {
        return drawable;
    }
}
