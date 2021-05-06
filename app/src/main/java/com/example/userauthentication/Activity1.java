package com.example.userauthentication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {



    private TextView timerTextView;
    private TextView aThousandTextView;

    private CountDownTimer countDownTimer;

    private long initialCountDownInMillis = 20000;
    private int timerInterval = 1000;
    private int remainingTime = 20;

    private int aThousand = 0;

    private final String REMAINING_TIME_KEY = "remaining time key";
    private final String A_THOUSAND_KEY = "a thousand key";



    @Override

    protected void onDestroy() {
        super.onDestroy();

        showToast("On Destroy Method is Called", Toast.LENGTH_SHORT);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        showToast("On Save Instance Is Called", Toast.LENGTH_SHORT);

        outState.putInt(REMAINING_TIME_KEY, remainingTime);
        outState.putInt(A_THOUSAND_KEY, aThousand);
        countDownTimer.cancel();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        showToast("On Create Methods is Called", Toast.LENGTH_SHORT);

        timerTextView = findViewById(R.id.textView);
        aThousandTextView = findViewById(R.id.textView2);
        Button tapTapButton = findViewById(R.id.button);

        aThousandTextView.setText(aThousand + "");

        if (savedInstanceState != null) {

            remainingTime = savedInstanceState.getInt(REMAINING_TIME_KEY);
            aThousand = savedInstanceState.getInt(A_THOUSAND_KEY);

            restoreTheGame();

        }

        tapTapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aThousand++;
                //aThousand = aThousand + 1;

                aThousandTextView.setText(aThousand + "");

                if (remainingTime > 0 && aThousand <= 0) {

                    Toast.makeText(Activity1.this, "Congratulation", Toast.LENGTH_SHORT).show();

                    showAlert("Congratulations", "Please reset the Game");

                }
            }
        });


        if (savedInstanceState == null) {
            countDownTimer = new CountDownTimer(initialCountDownInMillis, timerInterval) {
                @Override
                public void onTick(long millisUntilFinished) {

                    remainingTime = (int) millisUntilFinished / 1000;
                    timerTextView.setText(remainingTime + "");

                }

                @Override
                public void onFinish() {

                    Toast.makeText(Activity1.this, "Countdown finished", Toast.LENGTH_SHORT).show();


                    showAlert("Not interesting", "Would you like to try again?");


                }
            };


            countDownTimer.start();
        }

    }

    private void restoreTheGame() {

        int restoredRemainingTime = remainingTime;
        int restoredAThousand = aThousand;

        timerTextView.setText(restoredRemainingTime + "");
        aThousandTextView.setText(restoredAThousand + "");

        countDownTimer = new CountDownTimer((long) remainingTime * 1000, timerInterval) {
            @Override
            public void onTick(long milisUntilFinished) {

                remainingTime = (int) milisUntilFinished / 1000;
                timerTextView.setText(remainingTime + "");


            }

            @Override
            public void onFinish() {

                showAlert("Finished", "Would you like to reset the game?");

            }
        };


        countDownTimer.start();

    }

    private void resetTheGame() {

        if (countDownTimer != null) {
            countDownTimer.cancel();

            countDownTimer = null;
        }
        aThousand = 0;
        aThousandTextView.setText(Integer.toString(aThousand));

        timerTextView.setText(remainingTime + "");

        countDownTimer = new CountDownTimer(initialCountDownInMillis, timerInterval) {
            @Override
            public void onTick(long millisToFinish) {

                remainingTime = (int) millisToFinish / 1000;
                timerTextView.setText(remainingTime + "");
            }

            @Override
            public void onFinish() {
                showAlert("Finished", "Would you like to reset the game?");
            }
        };

        countDownTimer.start();
    }

    private void showAlert(String title, String message) {
        countDownTimer.cancel();
        AlertDialog alertDialog = new AlertDialog.Builder(Activity1.this)
                .setTitle(title)
                .setMessage(message+"\nYour speed is "+(float)(aThousand)/(20-remainingTime)+" taps per second")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked

                        resetTheGame();

                    }
                }).show();
        alertDialog.setCancelable(false);


    }

    private void showToast(String message, int duration) {

        Toast.makeText(this, message, duration).show();


    }
}