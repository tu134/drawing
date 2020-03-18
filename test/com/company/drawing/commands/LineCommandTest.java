package com.company.drawing.commands;

import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.drawables.Drawable;
import com.company.drawing.drawables.Line;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class LineCommandTest {
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
    public void execute() {
        LineCommand lineCommand = new LineCommand(new String[]{"1", "2", "6", "2"});
        Drawable drawable = lineCommand.getDrawable();
        Assert.assertTrue(drawable instanceof Line);
        Line line = (Line)drawable;
        line.draw(textCanvas);


        String[] expected = {
                "----------------------",
                "|                    |",
                "|xxxxxx              |",
                "|                    |",
                "|                    |",
                "----------------------"
        };
        Assert.assertEquals(Convert(expected), textCanvas.toString());
    }
}