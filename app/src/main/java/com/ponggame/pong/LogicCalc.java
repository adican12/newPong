package com.ponggame.pong;

import android.util.Log;

public class LogicCalc{
    // Const
    public LogicCalc() {}

    // Boot paddle move
    public void Boot_Paddle_position(Paddle boot, long t_new){
        if(boot.moveRight==true){
            boot.x +=  Move( boot.v0,(t_new- boot.t0)/1000)/1000 ;
            if(boot.x >= 0.8){
                boot.moveRight=false;
                boot.t0=System.currentTimeMillis();
            }
        }else{
            boot.x -=  Move( boot.v0,(t_new- boot.t0)/1000)/1000 ;
            if(boot.x <= 0){
                boot.moveRight=true;
                boot.t0=System.currentTimeMillis();
            }
        }
    }

    // Get ball position
    // First calculate new position - verticalMove()
    // After check if hits paddle or walls - hits() or hitsWalls()
    public void Ball_position(Ball ball,Paddle boot,Paddle user,long t) {
        // calc new position
        verticalMove(ball);
            //// CHECK FOR PADLLE OR SCORE
            if (ball.y >= 0.97555550000000f  &&  ball.y <=1.21000000000f ) {
//                Log.d("myapp", "ball.y :  "+ball.y);

                // inside fun hits update ball degree value
                //if( ball.recentHits==false) {
                    if (hits(ball, user)) {
                        Log.d("myapp", "__________________hits down________________");
                        // TODO: add sound fx
                  //      ball.recentHits = true;
                        return;

                    }
                //}
            }


//            if(ball.y < 0.97f && ball.y > 0.3){
//                ball.recentHits=true;
//            }

            if (ball.y > 1.21f) {
//                     ---- Reset ----
                ball.setX(0.5f);
                ball.setY(0.5f);
                ball.radAngle = (float) Math.PI * 3f / 2f;
//                ball.recentHits=false;
                // add goal to boot
                boot.goals++;
                return;

            }


            if (ball.y <= 0.025555000000f ) {
                // TODO: active hits fun
//                if( ball.recentHits==false){
                    if (hits(ball, boot)) {
                        Log.d("myapp", "__________________hits up________________");
                        // TODO: add sound fx
//                        ball.recentHits=true;
//                    }
                        return;
                }
            }

//            if(ball.y < 0.9600f && ball.y > 0.400){
//                ball.recentHits=false;
 //           }

            if (ball.y < 0f) {
//                    ---- Reset ----
                ball.setX(0.5f);
                ball.setY(0.5f);
                ball.radAngle = (float) (Math.PI / 2f);
//                ball.recentHits=false;
//                     add goal to user
                user.goals++;
                return;
            }

            /// CHECK FOR WALLS
            if (ball.x >= 0.97555500f ) {
                // inside fun hits update ball degree value
//                if(ball.recentHits==false) {
                    if (hitsWall(ball)) {
                        // TODO: add sound fx
//                        ball.recentHits = true;
                        return;
                    }
//                }
            }

            if (ball.x <= 0.05555000f) {
//                if(ball.recentHits==false) {
                    if (hitsWall(ball)) {
                        // TODO: add sound fx
//                        ball.recentHits = true;
                        return;
                    }
//                }
            }
    }

    // TODO: calculate vertical move - ball move
    private void verticalMove(Ball ball)
    {
        float speed=  ball.v0;
        ball.x += (float) (speed*Math.cos(ball.radAngle));
        ball.y += (float) (speed*Math.sin(ball.radAngle));
    }

    // Move paddle bot - calculate the new position
    private float Move(float v, float t){ return v*t; }

    // Check for hits  paddle -- calculate where the ball hits and change direction
    private boolean hits(Ball ball,Paddle paddle)
    {
        if ( ball.getX() >= paddle.getX()  && ball.getX() <= paddle.getX() +0.2f ) {
            float angle = (ball.x-paddle.x) / 0.2f;
            Log.d("myapp", "angle : "+angle  );
            if(angle >= 0.4999f && angle < 0.5f  ){
                angle+= 0.01f;
                Log.d("myapp", "angle : "+angle  );

            }
            ball.radAngle += (float) (0.5-angle)*( Math.PI/2f  ) ;
            verticalMove(ball);
            return true;
        }
        return  false;
    }

    // Check if hits the wall and change direction
    private boolean hitsWall(Ball ball)
    {
        if ( ball.getX() <= 0  || ball.getX() >= 1  ) {
            float angle = ball.x;
            ball.radAngle += (float) (0.5-angle)*( Math.PI/2f  ) ;
            verticalMove(ball);
            return true;
        }
        return  false;
    }
}
