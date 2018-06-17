package com.ponggame.pong;

import android.util.Log;

public class LogicCalc{
    private static final float animationSpeedFactor = 5.0f;

    public LogicCalc() {}

    public void Boot_Paddle_position(Paddle boot, long t_new){

//        Log.d("myapp","boot.x move right");
        if(boot.moveRight==true){
//            Log.d("myapp","boot.x before : "+boot.x);
            boot.x += (float) horizntelMove(boot.x, boot.v0,(t_new- boot.t0)/1000)/1000 ;
//            Log.d("myapp","boot.x after : "+boot.x);
            if(boot.x>0.8){
                // TODO: change direction faster
//                Log.d("myapp","change direction");
                boot.moveRight=false;
                boot.t0=System.currentTimeMillis();
            }
        }else{
//            Log.d("myapp","boot.x move left ");

            boot.x -= (float) horizntelMove(boot.x, boot.v0,(t_new- boot.t0)/1000)/1000 ;
            if(boot.x<0){
                // TODO: change direction faster
//                Log.d("myapp","change direction");
                boot.moveRight=true;
                boot.t0=System.currentTimeMillis();
            }
        }

        return;
    }

    public void Player_Paddle_position(Paddle user,long t_new){
        return;
    }

    public void Ball_position(Ball ball,long t_new){
        Log.d("myapp"," - Ball_position - ");
// TODO: Ball_position
        if(ball.moveDown==true){
            Log.d("myapp","Ball move down ");
//        ball.x +=
//        ball.y +=

        }else{
            Log.d("myapp","Ball move up ");
//        ball.x +=
//        ball.y +=

        }


        return;
    }

    private double calculateYLocation(float v0, long t0, long t1) {
        // time is in milliseconds, formula in seconds
        return v0 * animationSpeedFactor * (t1 - t0) / 1000;
    }

    private float horizntelMove(float x,float v, float t){
        return v*t;
    }

}
