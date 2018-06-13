package com.ponggame.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class pongView extends View {
    Paint paintBall,paintPaddle;

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

    public void init(){
        paintBall=new Paint();
        paintBall.setAntiAlias(true);
        paintBall.setColor(Color.RED);
        paintPaddle=new Paint();
        paintPaddle.setAntiAlias(true);
        paintPaddle.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(10, 10, 40, paintBall);
        canvas.drawRect(0,0,100,100,paintPaddle);
        postInvalidate();
    }
}
