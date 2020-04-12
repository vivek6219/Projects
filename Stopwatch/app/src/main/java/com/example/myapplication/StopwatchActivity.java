package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private  int seconds=0;
    private boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    public void onClickStart(View view)
    {
        isRunning = true;
    }

    public void onClickStop(View view)
    {
        isRunning=false;
    }

    public void onClickReset(View view)
    {
        isRunning=false;
        seconds =0;
    }

    private void runTimer()
    {
        final TextView timeView =(TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes,secs);
                timeView.setText(time);
                if(isRunning)
                    seconds++;
                handler.postDelayed(this,1000);
            }
        });

    }
}
