package com.company.drawing.commands;

import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Fill;
import com.company.drawing.drawables.Line;
import com.company.drawing.drawables.Rectangle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class FillCommandTest {
    TextCanvas textCanvas;

    @Before
    public void setUp() {
        textCanvas = new TextCanvas(20, 4);
        new Line(1, 2, 6, 2).draw(textCanvas);
        new Line(6, 3, 6, 4).draw(textCanvas);
        new Rectangle(14, 1, 18, 3).draw(textCanvas);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void execute() {

        DrawCommand fillCommand = new DrawCommand("B", new String[] {"10", "3", "o"});
        Drawable drawable = fillCommand.getDrawable();
        Assert.assertTrue(drawable instanceof Fill);
        Fill fill = (Fill)drawable;
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