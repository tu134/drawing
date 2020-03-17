package com.company.drawing.canvas;

public interface Canvas {
    void init(int width, int height);
    int getWidth();
    int getHeight();
    int getPixel(int x, int y);
    void setPixel(int x, int y);
    void setPixel(int x, int y, int color);
}
