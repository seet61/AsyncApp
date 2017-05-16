package com.example.seet.asyncapp;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class ProgressFragment extends Fragment {
    //Переменные
    int[] integers = null;
    ProgressBar indicatorBar;
    TextView statusView;
    Button processButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        integers = new int[100];
        for (int i=0; i<100; i++) {
            integers[i] = i+1;
        }

        indicatorBar = (ProgressBar) view.findViewById(R.id.indicator);
        statusView = (TextView) view.findViewById(R.id.statusView);
        processButton = (Button) view.findViewById(R.id.processButton);

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ProgressTask().execute();
            }
        });

        return view;
    }

    class ProgressTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            for (int i=0; i<integers.length; i++){
                publishProgress(i);
                SystemClock.sleep(200);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            indicatorBar.setProgress(values[0] + 1);
            statusView.setText("Статус: " + String.valueOf(values[0] + 1));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getActivity(), "Задача завершена", Toast.LENGTH_SHORT).show();
        }
    }
}
