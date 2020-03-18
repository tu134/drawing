package com.company.drawing.commands;

import com.company.drawing.drawables.Drawable;

public interface DrawCommand extends Command {
    public Drawable getDrawable();
}
