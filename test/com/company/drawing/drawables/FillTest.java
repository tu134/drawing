package com.company.drawing.drawables;

import com.company.drawing.canvas.TextCanvas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;
import static org.junit.Assert.*;

public class FillTest {
    TextCanvas textCanvas;

    @Before
    public void setUp() throws Exception {
        textCanvas = new TextCanvas();
        textCanvas.init(20, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void draw() {
        Line line = new Line(1, 2, 6, 2);
        line.draw(textCanvas);
        line = new Line(6, 3, 6, 4);
        line.draw(textCanvas);
        Rectangle rectangle = new Rectangle(14, 1, 18, 3);
        rectangle.draw(textCanvas);
        Fill fill = new Fill(10, 3, 'o');
        fill.draw(textCanvas);
        String[] expected = {
                "----------------------",
                "|oooooooooooooxxxxxoo|",
                "|xxxxxxooooooox   xoo|",
                "|     xoooooooxxxxxoo|",
                "|     xoooooooooooooo|",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected), textCanvas.toString());

    }
}