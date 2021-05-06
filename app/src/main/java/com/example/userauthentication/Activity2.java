package com.example.userauthentication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;
public class Activity2 extends AppCompatActivity {


    ArcSeekBar defaultSeekBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        defaultSeekBar= (ArcSeekBar) findViewById (R.id.defaultSeekBar );
        defaultSeekBar.setMaxProgress(60);
        defaultSeekBar.setProgress(30);



        defaultSeekBar.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke( int v) {
                Log.d("VALUE", String.valueOf(v-30));
                TextView thetextview = (TextView)  findViewById(R.id.textView1);
                thetextview.setAutoLinkMask(Integer.parseInt(String.valueOf(v-30)));
                thetextview.setText(String.valueOf(v-30));





            }
        });

    }

}