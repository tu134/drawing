package com.company.drawing.commands;

import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Line;
import com.company.drawing.exceptions.CommandArgumentsException;

public class LineCommand implements DrawCommand {
    private Line line;

    public LineCommand(String[] args)
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

            line = new Line(x1, y1, x2, y2);

        } catch (NumberFormatException e) {
            throw new CommandArgumentsException();
        }
    }

    @Override
    public Drawable getDrawable() {
        return line;
    }
}

