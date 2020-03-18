package com.company.drawing.commands;

import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Fill;
import com.company.drawing.exceptions.CommandArgumentsException;

public class FillCommand implements DrawCommand {
    private Fill fill;

    public FillCommand(String[] args)
    {
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

    @Override
    public Drawable getDrawable() {
        return fill;
    }
}
