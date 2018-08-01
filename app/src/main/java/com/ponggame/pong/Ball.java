package com.ponggame.pong;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Ball {
    float x,y,radius;
    long t0;
    float v0;

    float screenWidth, screenHeight;
    Paint paintBall;
    float radAngle;
    boolean moveDown,recentHits;

    // drawBall function - draw the ball in the current position
    public void drawBall(Canvas canvas){canvas.drawCircle(this.x* screenWidth,this.y*screenHeight,this.radius*screenWidth,paintBall);}

    // setters
    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }
    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
    }
    public void setX(float x) {this.x = x;}
    public void setY(float y) { this.y = y;}
    public void setRadius(float radius) {
        this.radius = radius;
    }

    // getters
    public float getX() {return x;}
    public float getY() {
        return y;
    }
    public float getRadius() {
        return radius;
    }

    // ball constr
    public Ball(float radius) {this.radius = radius;}

    // ball pram const
    public Ball(float _x, float _y, float _radius,Paint _paintBall) {
        this.x = _x;
        this.y = _y;
        this.radius = _radius;
        this.paintBall= _paintBall;
        this.t0=System.currentTimeMillis();
        // speed factor
        this.v0=0.015f;
        //// not in use
        this.moveDown=true;
        this.recentHits=false;
        // ball start stright down
        this.radAngle= (float) (Math.PI / 2f);
    }
}
