package com.ponggame.pong;

import android.util.Log;

public class LogicCalc{
    private static final float animationSpeedFactor = 5.0f;

    public LogicCalc() {}

    public void Boot_Paddle_position(Paddle boot, long t_new){
        if(boot.moveRight==true){
            boot.x += (float) Move(boot.x, boot.v0,(t_new- boot.t0)/1000)/1000 ;

            if(boot.x >= 0.8){
                // TODO: change direction faster
                boot.moveRight=false;
                boot.t0=System.currentTimeMillis();
            }
        }else{
            boot.x -= (float) Move(boot.x, boot.v0,(t_new- boot.t0)/1000)/1000 ;
            if(boot.x <= 0){
                // TODO: change direction faster
                boot.moveRight=true;
                boot.t0=System.currentTimeMillis();
            }
        }
        return;
    }

    public void Player_Paddle_position(Paddle user,long t_new){
        return;
    }

    public void Ball_position(Ball ball,Paddle boot,Paddle user,long t_new){
        Log.d("myapp"," - Ball_position - ");
        // TODO: Ball_position
        if(ball.moveDown==true){
            Log.d("myapp","Ball move down ");
            ball.y += (float)Move( ball.y , ball.v0 , (t_new- ball.t0)/1000 ) / 1000;
            //        ball.x +=
            if(ball.y >= 0.98f ){
                Log.d("myapp","chceck hits down");
                if( hits (ball,user) ){
                    Log.d("myapp","__________________hits down________________");
                }
            }
        }else{
            Log.d("myapp","Ball move up ");
//        ball.x +=
            ball.y -= (float)Move( ball.y , ball.v0 , (t_new- ball.t0)/1000 ) / 1000;
            if( ball.y >= 0.02f  ){
                Log.d("myapp","chceck hits up");

                if( hits (ball,boot) ){
                    Log.d("myapp","__________________hits up__________________");
                }
            }
        }
        return;
    }

    // TODO: calculate vertical move - ball move
    private double vertivalMove(float y,float v, float t) {
        // time is in milliseconds, formula in seconds
//        return v0 * animationSpeedFactor * (t1 - t0) / 1000;
        return  0;
    }

    private float Move(float x,float v, float t){
        return v*t;
    }

    private boolean hits(Ball ball,Paddle user){

        return false;
    }
}
