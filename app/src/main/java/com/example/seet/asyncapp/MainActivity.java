package com.example.seet.asyncapp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Переменные
    int clicks = 0;
    TextView clicksView;
    Button clicksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicksView = (TextView) findViewById(R.id.clicksView);
        clicksButton = (Button) findViewById(R.id.clicksButton);
        clicksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                clicksView.setText("Clicks: " + String.valueOf(clicks));
            }
        });
    }


}
