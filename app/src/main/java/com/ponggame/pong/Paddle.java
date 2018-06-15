package com.ponggame.pong;

import android.graphics.Canvas;

public class Paddle {
    float x,y, width,height;
    long t0,v0;
    float screenWidth, screenHeight;

    public void drawPaddle(long currentTime,Canvas canvas){

    }

    public Paddle(float width, float height) {
        this.width = width;

        this.height = height;
    }

    public Paddle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

}
