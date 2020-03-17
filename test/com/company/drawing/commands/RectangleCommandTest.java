package com.company.drawing.commands;

import com.company.drawing.canvas.TextCanvas;
import com.company.drawing.drawables.Line;
import com.company.drawing.drawables.Rectangle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.drawing.Utils.Convert;

public class RectangleCommandTest {
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
        RectangleCommand rectangleCommand = new RectangleCommand(textCanvas, new String[]{"14", "1", "18", "3"});
        rectangleCommand.execute();

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