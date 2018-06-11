package com.ponggame.pong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yarde on 11/06/2018.
 */

public class Game extends AppCompatActivity{


    private TextView Tap_To_Start;
    private ImageView pong_left;
    private ImageView pong_right;
    private ImageView Ball;

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
        Tap_To_Start.setVisibility(View.INVISIBLE);
        pong_left_Y = 500;

    }

    public boolean onTouchEvent(MotionEvent player) {

        if (player.getAction() == MotionEvent.ACTION_DOWN) {
            pong_left_Y -= 15;
        }

        pong_left.setY(pong_left_Y);

        return true;
    }



}
