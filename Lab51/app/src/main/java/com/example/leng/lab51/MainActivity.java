package com.example.leng.lab51;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView leftImage;
    ImageView rightImage;
    Button button;
    EditText editText;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftImage = (ImageView) findViewById(R.id.leftImage);
        rightImage = (ImageView) findViewById(R.id.rightImage);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.changeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumThread num1 = new NumThread(0); //create NumThread object
                num1.start(); // num1 thread execute
                NumThread num2 = new NumThread(1); //create numThread object
                num2.start(); // num2 thread execute
            }
        });
    }

    class NumThread extends Thread {
        int numindex;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public NumThread(int index) {
            this.numindex = index;
            images.add(R.drawable.num1); // input num1
            images.add(R.drawable.num2); // input num2
            images.add(R.drawable.num3); // input num3
        }

        /*
         * this function execute when RyanThread execute.
         */
        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "num #" + numindex + " state: " + stateIndex;

                handler.post(new Runnable() { //request the execution of runnable objects
                    @Override
                    public void run() {
                        editText.append(msg + "\n");
                        if (numindex == 0) { // the case of leftImage
                            leftImage.setImageResource(images.get(stateIndex)); // change image in leftImage
                        } else if (numindex == 1) { // the case of rightImage
                            rightImage.setImageResource(images.get(stateIndex)); // change image in rightImage
                        }
                    }
                });
                try {
                    int sleepTime = getRandomTime(500, 3000); // get time from 500 to 3000
                    Thread.sleep(sleepTime); // pause thread during sleeptime
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                if (stateIndex >= images.size()) { //if stateIndex exceed 3
                    stateIndex = 0; //initialize stateIndex
                }
            }
        }

        public int getRandomTime(int min, int max) {
            return min + (int) (Math.random() * (max - min));
        }
    }
}