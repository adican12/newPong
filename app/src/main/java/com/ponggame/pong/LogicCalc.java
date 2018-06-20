package com.ponggame.pong;

import android.util.Log;

public class LogicCalc{

    public LogicCalc() {}

    public void Boot_Paddle_position(Paddle boot, long t_new){
        if(boot.moveRight==true){
            boot.x +=  Move( boot.v0,(t_new- boot.t0)/1000)/1000 ;

            if(boot.x >= 0.8){
                // TODO: change direction faster
                boot.moveRight=false;
                boot.t0=System.currentTimeMillis();
            }
        }else{
            boot.x -=  Move( boot.v0,(t_new- boot.t0)/1000)/1000 ;
            if(boot.x <= 0){
                // TODO: change direction faster
                boot.moveRight=true;
                boot.t0=System.currentTimeMillis();
            }
        }
        return;
    }

    // TODO: remove long t_new from Ball_position
    public void Ball_position(Ball ball,Paddle boot,Paddle user){
        // TODO: Ball_position


        // TODO:   Importent check if this func should call before all if check
        verticalMove(ball);

            if(ball.y >= 0.98f  ){
                // inside fun hits update ball degree value
                if( hits (ball,user) ){
                    Log.d("myapp","__________________hits down________________");
                    // TODO: add sound fx

                }

                if(ball.y > 1f){
//                     ---- Reeset ----
                    ball.setX(0.5f);
                    ball.setY(0.5f);
                    ball.radAngle=90;
                }
            }

            if( ball.y <= 0.02f  ){
                // TODO: active hits fun
                if( hits (ball,boot) ){
                    Log.d("myapp","__________________hits down________________");
                    // TODO: add sound fx
                }

                if(ball.y < 0f){
//                    ---- Reeset ----
                    ball.setX(0.5f);
                    ball.setY(0.5f);
                    ball.radAngle=270;
                }
            }

        if(ball.x >= 0.97f  ){
            // inside fun hits update ball degree value
            // TODO: add sound fx
            // right wall convertor
            if(ball.radAngle > 180) {
                ball.radAngle -=90;
            }else{
                ball.radAngle +=90;
            }
        }

        if( ball.x <= 0.05f  ){
            // opposite angle
            // left wall hits
            // TODO: add sound fx
            if(ball.radAngle > 180) {
                ball.radAngle +=90;
            }else{
                ball.radAngle -=90;
            }
        }
        return;
    }


    // TODO: calculate vertical move - ball move
    private void verticalMove(Ball ball)
    {
        ball.x += (float) (ball.v0*Math.cos(Math.toRadians(ball.radAngle)));
        ball.y += (float) (ball.v0*Math.sin(Math.toRadians(ball.radAngle)));
    }


    private float Move(float v, float t){ return v*t; }


    private boolean hits(Ball ball,Paddle paddle)
    {
        float dividerPaddle=0.05f;
        int i;

        for(i=1;i < (dividerPaddle*100) + 1 ;i++) {
            if (ball.getX() >= paddle.getX() && ball.getX() <= paddle.getX() + i*dividerPaddle) {
            /// check the divide part where the ball hit and update degree value
                if(ball.radAngle < 180 ){
                    if(i==1){
                        ball.radAngle = 210;
                    }
                    else if(i==2){
                        ball.radAngle = 240;
                    }
                    else if(i==3){
                        ball.radAngle = 270;
                    }
                    else if(i==4){
                        ball.radAngle = 300;
                    }
                    else if(i==5){
                        ball.radAngle = 330;
                    }
                }else{
                    if(i==1){
                        ball.radAngle = 150;
                    }
                    else if(i==2){
                        ball.radAngle = 120;
                    }
                    else if(i==3){
                        ball.radAngle = 90;
                    }
                    else if(i==4){
                        ball.radAngle = 60;
                    }
                    else if(i==5){
                        ball.radAngle = 30;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
