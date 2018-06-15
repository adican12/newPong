package com.ponggame.pong;

import android.graphics.Canvas;

public class Ball {
    float x,y,radius;
    long t0,v0;
    float screenWidth, screenHeight;

    public void drawBall(long currentTime,Canvas canvas){

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

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Ball(float radius) {

        this.radius = radius;
    }

    public Ball(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
