package com.bilgic.runnablehandler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button buttonStart, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonStart = findViewById(R.id.button);
        buttonStop = findViewById(R.id.button2);

        number = 0;
        handler = new Handler();
    }

    @SuppressLint("SetTextI18n")
    public void start(View view) {
        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);

        handler.removeCallbacks(runnable);

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
    }

    @SuppressLint("SetTextI18n")
    public void stop(View view) {
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);

        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time: " + number);
    }
}
