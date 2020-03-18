package com.company.drawing.drawables;

import com.company.drawing.canvas.TextCanvas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

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
        new Line(1, 2, 6, 2).draw(textCanvas);
        new Line(6, 3, 6, 4).draw(textCanvas);
        new Rectangle(14, 1, 18, 3).draw(textCanvas);

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

    @Test
    public void draw2() {
        new Line(2, 1, 17, 3).draw(textCanvas);
        new Line(2, 1, 1, 4).draw(textCanvas);
        new Line(17, 3, 1, 4).draw(textCanvas);

        Fill fill = new Fill(5, 3, 'y');
        fill.draw(textCanvas);
        String[] expected = {
                "----------------------",
                "| xxxx               |",
                "| xyyyxxxxxxxx       |",
                "|xyyyyyyyyxxxxxxxx   |",
                "|xxxxxxxxx           |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected), textCanvas.toString());
    }
}




