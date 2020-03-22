package com.company.drawing.commands;

import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Rectangle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class RectangleCommandTest {
    TextCanvas textCanvas;

    @Before
    public void setUp() {
        textCanvas = new TextCanvas(20, 4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void execute() {
        DrawCommand rectangleCommand = new DrawCommand("R", new String[]{"14", "1", "18", "3"});
        Drawable drawable = rectangleCommand.getDrawable();
        Assert.assertTrue(drawable instanceof Rectangle);
        Rectangle rectangle = (Rectangle)drawable;
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