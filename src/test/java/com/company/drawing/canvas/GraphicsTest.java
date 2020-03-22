package com.company.drawing.canvas;

import com.company.drawing.drawables.Fill;
import com.company.drawing.drawables.Line;
import com.company.drawing.drawables.Rectangle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class GraphicsTest {
    private Graphics graphics;

    @Before
    public void setUp() throws Exception {
        graphics = new Graphics(new TextCanvas(20, 4));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addDrawable() {
        graphics.addDrawable(new Line(1, 2, 6, 2));
        graphics.addDrawable(new Line(6, 3, 6, 4));
        graphics.addDrawable(new Rectangle(14, 1, 18, 3));
        graphics.addDrawable(new Fill(10, 3, 'o'));

        String[] expected = {
                "----------------------",
                "|oooooooooooooxxxxxoo|",
                "|xxxxxxooooooox   xoo|",
                "|     xoooooooxxxxxoo|",
                "|     xoooooooooooooo|",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected), graphics.toString());
    }

    @Test
    public void testToString() {
    }
}