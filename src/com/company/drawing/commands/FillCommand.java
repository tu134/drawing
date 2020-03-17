package com.company.drawing.commands;

import com.company.drawing.drawables.Fill;
import com.company.drawing.canvas.Canvas;
import com.company.drawing.exceptions.CommandArgumentsException;

public class FillCommand implements Command {
    private Canvas canvas;
    private Fill fill;

    public FillCommand(Canvas canvas, String[] args)
    {
        this.canvas = canvas;
        if (args == null)
            throw new CommandArgumentsException();

        if (args.length != 3)
            throw new CommandArgumentsException();

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int color = args[2].charAt(0);

            if(x < 0 || y < 0) {
                throw new CommandArgumentsException();
            }

            fill = new Fill(x, y, color);

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new CommandArgumentsException();
        }
    }

    public void execute()
    {
        fill.draw(canvas);
    }

}
