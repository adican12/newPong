package com.ponggame.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.text.LoginFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class PongView extends View {
    Paint paintBall,paddlePaint;
    Paddle user,boot;
    Ball gameBall;
    LogicCalc logic=new LogicCalc();

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

        mDetector= new GestureDetectorCompat(this.getContext(),new MyGestureListener());
//        mDetector.setOnDoubleTapListener(listener);

        }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "myapp";

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG,"onDown: " + event.toString());

                float tmp_x=event.getX()/1000;
                if(tmp_x>0.8f){
                    tmp_x=0.8f;
                }
                user.setX(tmp_x);
                postInvalidateOnAnimation();
                return true;
            }




        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDoubleTap: " + e.toString() );
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            float tmp_x=e.getX()/1000;
            if(tmp_x>0.8f){
                tmp_x=0.8f;
            }
            user.setX(tmp_x);
            postInvalidateOnAnimation();
            super.onLongPress(e);
        }

        @Override
        //TODO: what's fling
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());

            float tmp_x=event1.getX()/1000;
            if(tmp_x>0.8f){
                tmp_x=0.8f;
            }
            user.setX(tmp_x);
            postInvalidateOnAnimation();
            return true;
        }
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
        // TODO: active dectetor
        //        this.mDetector.onTouchEvent(event);

        if (event.getAction() == MotionEvent.ACTION_DOWN ||
                event.getAction() == MotionEvent.ACTION_MOVE) {
                float tmp_x=event.getX()/1000;
                if(tmp_x>0.8f){
                    tmp_x=0.8f;
                }
                user.setX(tmp_x);
            postInvalidateOnAnimation();
            return true;
        }
//        // will trigger a new call to onDraw()
        postInvalidateOnAnimation();
        return super.onTouchEvent(event);
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
        logic.Ball_position(gameBall,boot,user);
        gameBall.drawBall(canvas);

        postInvalidateOnAnimation();
    }

}
