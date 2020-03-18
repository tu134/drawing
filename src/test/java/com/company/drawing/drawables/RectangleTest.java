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
    public void setUp() throws Exception {
        textCanvas = new TextCanvas();
        textCanvas.init(20, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void draw() {
        Rectangle rectangle = new Rectangle(14, 1, 18, 3);
        rectangle.draw(textCanvas);
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
}