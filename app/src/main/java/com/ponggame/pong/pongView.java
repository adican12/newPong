package com.ponggame.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class pongView extends View {
    Paint paintBall,paddlePaint;
    Paddle user,boot;
    Ball gameBall;
    float screenWidth,screenHeight;

    public pongView(Context context) {
        super(context);
        init();
    }

    public pongView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public pongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public pongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        // Paint blue
        paintBall=new Paint();
        paintBall.setAntiAlias(true);
        paintBall.setColor(Color.BLUE);

        // Paint red
        paddlePaint=new Paint();
        paddlePaint.setAntiAlias(true);
        paddlePaint.setColor(Color.RED);

        // pojo create user , boot and ball
        user=new Paddle(0.4f,0f,0.2f,0.01f);
        boot=new Paddle(0.4f,0.99f,0.2f,0.01f);
        gameBall=new Ball(0.5f,0.5f,0.02f);


    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        // TODO: insert to ball paddle
        screenWidth = xNew;
        screenHeight = yNew;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //        canvas.drawColor(0xf303f300);
        long t=System.currentTimeMillis();

        // ball
        canvas.drawCircle(gameBall.x* screenWidth,gameBall.y*screenHeight,gameBall.radius*screenWidth,paintBall);

        // Boot
        canvas.drawRect(boot.x*screenWidth ,boot.y*screenHeight,(boot.x+boot.width)*screenWidth,(boot.y+boot.height)*screenHeight,paddlePaint);

        // user
        canvas.drawRect(user.x*screenWidth ,user.y*screenHeight,(user.x+user.width)*screenWidth,(user.y+user.height)*screenHeight,paddlePaint);

    }


    public void start(){
        postInvalidateOnAnimation();
    }
}
