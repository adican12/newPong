package com.ponggame.pong;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Paddle {
    float x,y, width,height;
    long t0,v0;
    float screenWidth, screenHeight;
    Paint paddlePaint;

    public void drawPaddle(long currentTime,Canvas canvas){
        canvas.drawRect(this.x*screenWidth ,this.y*screenHeight,(this.x+this.width)*screenWidth,(this.y+this.height)*screenHeight,paddlePaint);
    }

    public Paddle(float _width, float _height) {
        this.width = _width;
        this.height = _height;
    }

    public Paddle(float _x, float _y, float _width, float _height,Paint _paddlePaint) {
        this.x = _x;
        this.y = _y;
        this.width = _width;
        this.height = _height;
        this.paddlePaint=_paddlePaint;
        // defult value
        this.t0=System.currentTimeMillis();
        this.v0=100;
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


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public void setScreenHeight(float screenHeight) {
        this.screenHeight = screenHeight;
    }
}
