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

//    public void Player_Paddle_position(Paddle user,long t_new){
//
//        return;
//    }

    public void Ball_position(Ball ball,Paddle boot,Paddle user,long t_new){
        // TODO: Ball_position
        if(ball.moveDown==true){
            Log.d("myapp","before --  ball.x :"+ball.x);
            ball.x +=(float)calculateXLocation( ball.v0, ball.angleRad, (t_new- ball.t0)/1000 ) / 1000;
            Log.d("myapp","after -- ball.x :"+ball.x);

            Log.d("myapp","before -- ball.y :"+ball.y);
            ball.y -= ball.v0 == 0 ? 0 : (float) (ball.x * Math.tan(ball.angleRad) - (ball.x * ball.x) / (2 * ball.v0 * ball.v0 * Math.cos(ball.angleRad) * Math.cos(ball.angleDeg)));
            Log.d("myapp","after -- ball.y :"+ball.y);

            if(ball.y >= 0.98f ){
                if( hits (ball,user) ){
                    Log.d("myapp","__________________hits down________________");
                    ball.moveDown=false;
                }
            }
        }else{
//        ball.x +=
            ball.y -= Move( ball.y , ball.v0 , (t_new- ball.t0)/1000 ) / 1000;
            if( ball.y >= 0.02f  ){
                if( hits (ball,boot) ){
                    Log.d("myapp","__________________hits up__________________");
                    ball.moveDown=true;
                }
            }
        }
        return;
    }

    // TODO: calculate vertical move - ball move
//    private float verticalMove(Ball ball,long t) {
//        float x = calculateXLocation(ball.v0, ball.angleDeg, t);
//        float y = ball.v0 == 0 ? 0 :
//                x * Math.tan(ball.angleRad)
//                        - (gravity * x * x) / (2 * ball.v0 * ball.v0 * Math.cos(ball.angleRad) * Math.cos(ball.angleDeg));

//        ball.x = (float) x;
//        ball.y = (float) y;
//             time is in milliseconds, formula in seconds
//        return ball.v0 * animationSpeedFactor * t / 1000;
//    }

    private double calculateXLocation(float v0, double radAngle, long t) {
        // time is in milliseconds, formula in seconds
        return Math.cos(radAngle) * v0 * (t) / 1000;
    }


    private float Move(float x,float v, float t){
        return v*t;
    }

    private boolean hits(Ball ball,Paddle paddle){
        if ( ball.getX() >= paddle.getX() &&  ball.getX() <= paddle.getX()+0.2f ){
            return true;
        }else {
            return false;
        }
    }
}
