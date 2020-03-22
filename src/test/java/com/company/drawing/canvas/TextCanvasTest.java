package com.company.drawing.canvas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextCanvasTest {

    TextCanvas textCanvas;

    @Before
    public void setUp() throws Exception {
        textCanvas = new TextCanvas(20, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getWidth() {
        Assert.assertEquals(20, textCanvas.getWidth());
    }

    @Test
    public void getHeight() {
        Assert.assertEquals(4, textCanvas.getHeight());
    }

    @Test
    public void setGetPixel() {
        Assert.assertEquals(textCanvas.getPixel(2, 3), ' ');
        textCanvas.setPixel(2, 3, 'o');
        Assert.assertEquals(textCanvas.getPixel(2, 3), 'o');
    }

}