package com.ponggame.pong;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yarde on 11/06/2018.
 */

public class Game extends AppCompatActivity{


    private TextView Tap_To_Start;
    private ImageView pong_left;
    private ImageView pong_right;
    private ImageView Ball;

    private int frame_height ;
    private int pong_left_size ;
    private int screenWidth ;
    private int screenHeight ;

    WindowManager wm = getWindowManager();
    Display display = wm.getDefaultDisplay();




    private Handler handler = new Handler();
    private Timer timer = new Timer();



    private boolean action_flg = false ;
    private boolean start_flg = false ;

    //postion

    private int pong_left_Y;
    private int pong_right_Y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        play_pong();

        ////
    }


    public void play_pong() {

        Tap_To_Start = (TextView) findViewById(R.id.Tap_to_start);
        pong_left = (ImageView) findViewById(R.id.left_pong);
        pong_right = (ImageView) findViewById(R.id.right_pong);
        Ball = (ImageView) findViewById(R.id.Ball);


        Ball.setX(-80);
        Ball.setY(-80);


        //temporary
        //Tap_To_Start.setVisibility(View.INVISIBLE);
        //pong_left_Y = 500;



    }


    public void  changePos(){

        if(action_flg == true)
        {
            pong_left_Y -= 15;
        } else {

            pong_left_Y += 15;


        }

        //if(pong_left_Y<0) pong_left_Y =0;


        pong_left.setY(pong_left_Y);}




    public boolean onTouchEvent(MotionEvent player) {

        if(start_flg ==false)
        {

            start_flg =true;

//            FrameLayout frame = (FrameLayout)findViewById(R.id.frame);
//            frame_height = frame.getHeight();

            pong_left_Y = (int) pong_left.getY();

            pong_left_size = pong_left.getHeight();


            Tap_To_Start.setVisibility(View.GONE);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            },0,20);







        }else {
            if (player.getAction() == MotionEvent.ACTION_DOWN) {
                //pong_left_Y -= 15;
                action_flg = true;

            } else if (player.getAction() == MotionEvent.ACTION_UP)
            {
                action_flg = false ;
            }



        }



        return true;
    }



}
