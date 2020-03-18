package com.company.drawing.drawables;

import com.company.drawing.canvas.Canvas;

import java.awt.*;
import java.util.ArrayDeque;

public class Fill implements Drawable {

    private int x;
    private int y;
    private int color;

    public Fill(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        //algorithm from https://en.wikipedia.org/wiki/Flood_fill
        //Flood-fill(node, target-color, replacement-color):
        //1. If target-color is equal to replacement-color, return.
        //2. If color of node is not equal to target-color, return.
        //3. Set Q to the empty queue.
        //4. Add node to Q.
        //5. For each element N of Q:
        //6.         Set w and e equal to N.
        //7.         Move w to the west until the color of the node to the west of w no longer matches target-color.
        //8.         Move e to the east until the color of the node to the east of e no longer matches target-color.
        //9.         For each node n between w and e:
        //10.             Set the color of n to replacement-color.
        //11.             If the color of the node to the north of n is target-color, add that node to Q.
        //12.             If the color of the node to the south of n is target-color, add that node to Q.
        //13. Continue looping until Q is exhausted.
        //14. Return.

        if (x < 1 || x > canvas.getWidth() || y < 0 || y > canvas.getHeight()) return;
        int tc = canvas.getPixel(x, y);
        if (tc == color) return;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));

        while (queue.size() > 0)
        {
            Point n = queue.remove();
            Point w = new Point(n);
            Point e = new Point(n);
            while (w.x - 1 >= 1 && canvas.getPixel(w.x - 1, w.y) == tc) --w.x;
            while (e.x + 1 <= canvas.getWidth() && canvas.getPixel(e.x + 1, e.y) == tc) ++e.x;

            for (int i = w.x; i <= e.x; ++i)
            {
                canvas.setPixel(i, n.y, color);
                if (n.y - 1 >= 1 && canvas.getPixel(i, n.y - 1) == tc)
                    queue.add(new Point(i, n.y - 1));
                if (n.y + 1 <= canvas.getHeight() && canvas.getPixel(i, n.y + 1) == tc)
                    queue.add(new Point(i, n.y + 1));
            }
        }
    }
}
