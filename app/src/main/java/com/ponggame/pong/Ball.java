package com.ponggame.pong;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ball {
    float x,y,radius;
    long t0,v0;
    float screenWidth, screenHeight;
    Paint paintBall;
    public void drawBall(long currentTime,Canvas canvas){

        canvas.drawCircle(this.x* screenWidth,this.y*screenHeight,this.radius*screenWidth,paintBall);
        this.y+=0.01f;
    }

    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }


    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
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

    public Ball(float _x, float _y, float _radius,Paint _paintBall) {
        this.x = _x;
        this.y = _y;
        this.radius = _radius;
        this.paintBall= _paintBall;
    }


}
