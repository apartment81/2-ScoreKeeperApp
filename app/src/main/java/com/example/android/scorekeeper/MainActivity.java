package com.example.android.scorekeeper;


import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public void addFifteenPlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 15;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addTenPlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 10;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addSevenPlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 7;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addFourPlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 4;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addTwoPlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 2;
        displayForPlayerOne(scorePlayerOne);
    }

    public void addOnePlayerOne(View view) {
        scorePlayerOne = scorePlayerOne + 1;
        displayForPlayerOne(scorePlayerOne);
    }


    public void addFifteenPlayerTwo(View view) {
        scorePlayerTwo += 15;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addTenPlayerTwo(View view) {
        scorePlayerTwo += 10;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addSevenPlayerTwo(View view) {
        scorePlayerTwo += 7;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addFourPlayerTwo(View view) {
        scorePlayerTwo += 4;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addTwoPlayerTwo(View view) {
        scorePlayerTwo += 2;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void addOnePlayerTwo(View view) {
        scorePlayerTwo += 1;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void resetScore(View v) {

        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        displayForPlayerOne(scorePlayerOne);
        displayForPlayerTwo(scorePlayerTwo);

    }

    public void displayForPlayerOne(int score) {
        TextView scoreViewA = findViewById(R.id.player_one_score);
        scoreViewA.setText(String.valueOf(score));

    }

    public void displayForPlayerTwo(int score) {
        TextView scoreViewB = findViewById(R.id.player_two_score);
        scoreViewB.setText(String.valueOf(score));
    }

}
