package com.ponggame.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PongView extends View {
    Paint paintBall,paddlePaint;
    Paddle user,boot;
    Ball gameBall;
    LogicCalc logic=new LogicCalc();
    long mDowntimestamp;

    private GestureDetectorCompat mDetector;

    public PongView(Context context) {
        super(context);
        init(context);
    }

    public PongView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public PongView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
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

        // set screen width and height to pojo
        user.setScreenWidth(xNew);
        user.setScreenHeight(yNew);
        boot.setScreenWidth(xNew);
        boot.setScreenHeight(yNew);
        gameBall.setScreenWidth(xNew);
        gameBall.setScreenHeight(yNew);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        long ts=System.currentTimeMillis();
//                this.mDetector.onTouchEvent(event);

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN: {
                    float tmp_x = event.getX() / getWidth();
                    user.setX(tmp_x);
                    invalidate();
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                     float tmp_x = event.getX() / getWidth();
                        user.setX(tmp_x);
                        invalidate();
                        break;
                }

                // TODO: double tap
//                 TODO: pause game
            }
            mDowntimestamp=ts;
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        long t=System.currentTimeMillis();
        // TODO: add sound fx
        // Boot
        logic.Boot_Paddle_position(boot,t);
        boot.drawPaddle(canvas);

        // user
        user.drawPaddle(canvas);

        // ball
        logic.Ball_position(gameBall,boot,user,t);
        gameBall.drawBall(canvas);

        postInvalidateOnAnimation();
    }

}
