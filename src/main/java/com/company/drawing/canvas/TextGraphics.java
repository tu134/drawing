package com.company.drawing.canvas;

import com.company.drawing.drawables.Drawable;

import java.util.ArrayList;
import java.util.List;

public class TextGraphics {

    List<Drawable> drawables = new ArrayList<>();
    Canvas canvas;
    int height;
    int width;

    public TextGraphics(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new TextCanvas();
        this.canvas.init(width, height);
    }

    public void addDrawable(Drawable drawable) {
        drawables.add(drawable);
        drawable.draw(canvas);
    }

    @Override
    public String toString()  {
        return canvas.toString();
    }
}
