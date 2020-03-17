package com.company.drawing.drawables;

import com.company.drawing.canvas.Canvas;

public class Rectangle implements Drawable {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas) {
        Line line1 = new Line(x1, y1, x1, y2);
        line1.draw(canvas);
        Line line2 = new Line(x1, y1, x2, y1);
        line2.draw(canvas);
        Line line3 = new Line(x1, y2, x2, y2);
        line3.draw(canvas);
        Line line4 = new Line(x2, y1, x2, y2);
        line4.draw(canvas);
    }
}
