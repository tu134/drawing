package com.company.drawing.drawables;

import com.company.drawing.canvas.TextCanvas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class RectangleTest {
    TextCanvas textCanvas;

    @Before
    public void setUp() {
        textCanvas = new TextCanvas(20, 4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void draw() {
        new Rectangle(14, 1, 18, 3).draw(textCanvas);

        String[] expected = {
                "----------------------",
                "|             xxxxx  |",
                "|             x   x  |",
                "|             xxxxx  |",
                "|                    |",
                "----------------------"
        };

        Assert.assertEquals(Convert(expected), textCanvas.toString());
    }

    public void draw2() {
        new Rectangle(-10, -10, 10, 2).draw(textCanvas);

        String[] expected = {
                "----------------------",
                "|         x          |",
                "|xxxxxxxxxx          |",
                "|                    |",
                "|                    |",
                "----------------------"
        };

        Assert.assertEquals(Convert(expected), textCanvas.toString());
    }
}