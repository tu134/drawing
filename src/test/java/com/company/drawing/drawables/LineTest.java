package com.company.drawing.drawables;

import com.company.drawing.canvas.TextCanvas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class LineTest {
    TextCanvas textCanvas;

    @Before
    public void setUp() throws Exception {
        textCanvas = new TextCanvas(20, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void draw() {
        Line line = new Line(1, 2, 6, 2);
        line.draw(textCanvas);
        String[] expected1 = {
                "----------------------",
                "|                    |",
                "|xxxxxx              |",
                "|                    |",
                "|                    |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected1), textCanvas.toString());

        line = new Line(6, 3, 6, 4);
        line.draw(textCanvas);
        String[] expected2 = {
                "----------------------",
                "|                    |",
                "|xxxxxx              |",
                "|     x              |",
                "|     x              |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected2), textCanvas.toString());
    }

    @Test
    public void draw2() {
        Line line = new Line(2, 1, 17, 3);
        line.draw(textCanvas);
        String[] expected2 = {
                "----------------------",
                "| xxxx               |",
                "|     xxxxxxxx       |",
                "|             xxxx   |",
                "|                    |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected2), textCanvas.toString());
    }

    @Test
    public void draw3() {
        Line line = new Line(-10, 2, 50, 2);
        line.draw(textCanvas);
        String[] expected2 = {
                "----------------------",
                "|                    |",
                "|xxxxxxxxxxxxxxxxxxxx|",
                "|                    |",
                "|                    |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected2), textCanvas.toString());
    }

}
