package com.ponggame.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PongView extends View {
    Paint paintBall,paddlePaint;
    Paddle user,boot;
    Ball gameBall;
    float screenWidth,screenHeight;
    LogicCalc logic=new LogicCalc();

    public PongView(Context context) {
        super(context);
        init();
    }

    public PongView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        boot=new Paddle(0.4f,0f,0.2f,0.02f,paddlePaint);
        user=new Paddle(0.4f,0.98f,0.2f,0.02f,paddlePaint);
        gameBall=new Ball(0.5f,0.5f,0.02f,paintBall);


    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        // TODO: insert to ball paddle
        screenWidth = xNew;
        screenHeight = yNew;

        user.setScreenWidth(xNew);
        user.setScreenHeight(yNew);

        boot.setScreenWidth(xNew);
        boot.setScreenHeight(yNew);

        gameBall.setScreenWidth(xNew);
        gameBall.setScreenHeight(yNew);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //        canvas.drawColor(0xf303f300);
        long t=System.currentTimeMillis();

        // Boot
//        canvas.drawRect(boot.x*screenWidth ,boot.y*screenHeight,(boot.x+boot.width)*screenWidth,(boot.y+boot.height)*screenHeight,paddlePaint);
        logic.Boot_Paddle_position(boot,t);
        boot.drawPaddle(canvas);

        // user
        logic.Player_Paddle_position(user,t);
        canvas.drawRect(user.x*screenWidth ,user.y*screenHeight,(user.x+user.width)*screenWidth,(user.y+user.height)*screenHeight,paddlePaint);

        // ball
        logic.Ball_position(gameBall,boot,user,t);
        gameBall.drawBall(canvas);

        postInvalidateOnAnimation();
    }

}
