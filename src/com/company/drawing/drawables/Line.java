package com.company.drawing.drawables;

import com.company.drawing.canvas.Canvas;

public class Line implements Drawable {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas) {

        if (x1 == x2) //vertical line
        {
            if (x1 < 1 || x1 > canvas.getWidth()) return;
            for (var y = Math.max(1, Math.min(y1, y2)); y <= Math.min(canvas.getHeight(), Math.max(y1, y2)); ++y)
                canvas.setPixel(x1, y);
        }
        else if (y1 == y2) //horizontal line
        {
            if (y1 < 1 || y1 > canvas.getHeight()) return;
            for (var x = Math.max(1, Math.min(x1, x2)); x <= Math.min(canvas.getWidth(), Math.max(x1, x2)); ++x)
                canvas.setPixel(x, y1);
        }
        else //bonus, DDA line drawing
        {
            double dx = x2 - x1;
            double dy = y2 - y1;
            var step = Math.max(Math.abs(dx), Math.abs(dy));
            dx = dx / step;
            dy = dy / step;
            double x = x1;
            double y = y1;

            for (var i = 0; i <= step; ++i)
            {
                canvas.setPixel((int)Math.round(x), (int)Math.round(y));
                x = x + dx;
                y = y + dy;
            }
        }
    }
}
