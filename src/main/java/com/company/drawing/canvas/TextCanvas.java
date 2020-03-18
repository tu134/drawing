package com.company.drawing.canvas;

import java.util.Arrays;

public class TextCanvas implements Canvas {

    private final static char backgroundColor = ' ';
    private final static char foregroundColor = 'x';

    private char[] buffer;
    private int width;
    private int height;

    public TextCanvas()
    {
        width = 0;
        height = 0;
        buffer = null;
    }

    @Override
    public void init(int width, int height)
    {
        if(width <= 0 || height <= 0) throw new IllegalArgumentException ();
        this.width = width;
        this.height = height;
        buffer = new char[width* height];
        Arrays.fill(buffer, backgroundColor);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPixel(int x, int y) {
        return buffer[(y - 1) * width + x - 1];
    }

    @Override
    public void setPixel(int x, int y) {
        setPixel(x, y, foregroundColor);
    }

    @Override
    public void setPixel(int x, int y, int color) {
        buffer[(y - 1) * width + x - 1] = (char)color;
    }

    @Override
    public String toString()
    {
        if (buffer == null) return "";
        StringBuilder builder = new StringBuilder();

        builder.append("-".repeat(getWidth() + 2)).append(System.lineSeparator());
        for (int i = 0; i < getHeight(); ++i)
        {
            char[] part = new char[getWidth()];
            if (getWidth() >= 0) System.arraycopy(buffer, i * getWidth(), part, 0, getWidth());

            builder.append('|').append(part).append('|').append(System.lineSeparator());
        }
        builder.append("-".repeat(getWidth() + 2)).append(System.lineSeparator());
        return builder.toString();
    }

}
