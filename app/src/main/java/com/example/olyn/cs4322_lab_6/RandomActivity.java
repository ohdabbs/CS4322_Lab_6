/*
  Class: 	 	          CS 4322/section01
  Term:		              Fall 2017
  Name: 		          Olyn Dabbs
  Instructor:             Dr. Selena He
  Lab 5:                  Random Numbers with Threads
 */

package com.example.olyn.cs4322_lab_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomActivity extends AppCompatActivity {

    Button start, stop;
    Random r;
    boolean b = false;

    Thread t = new Thread(){
        @Override
        public void run() {
            while(t.isInterrupted()==false) {
                b = true;
                Log.v("Random", "Random number is " + r.nextInt(100));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        r = new Random();

        start = (Button)findViewById(R.id.startButton);
        stop = (Button)findViewById(R.id.stopButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b == false) {
                    Log.v("Status", "Random generator has been started.");
                    t.start();
                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Status", "Random generator has been interrupted.");
                t.interrupt();
                b = false;
            }
        });


    }
}


