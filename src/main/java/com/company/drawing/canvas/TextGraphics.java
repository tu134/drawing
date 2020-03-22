package com.company.drawing.canvas;

import com.company.drawing.drawables.Drawable;

import java.util.ArrayList;
import java.util.List;

public class TextGraphics {

    private List<Drawable> drawables = new ArrayList<>();
    private Canvas canvas;

    public TextGraphics(Canvas canvas) {
        this.canvas = canvas;
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
