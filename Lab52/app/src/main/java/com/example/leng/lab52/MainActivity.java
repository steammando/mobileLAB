package com.example.leng.lab52;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button calButton;
    TextView Text1;
    TextView Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        calButton = findViewById(R.id.button);
        Text1 = findViewById(R.id.TextView1);
        Text2 = findViewById(R.id.TextView2);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Text1.setText("");
                Text2.setText("");
                int temp = Integer.parseInt(editText.getText().toString()); // get integer value from editText
                new Facto(temp).execute(); // execute Facto object
            }
        });
    }

    private class Facto extends AsyncTask<Void, Integer, Void> {
        int num = 0;
        int result = 1;

        Facto(int temp) {
            num = temp;
        } // constructor for receiving integer value

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = num; i > 0; i--) {
                try {
                    Thread.sleep(500); // get time
                    publishProgress(i); //Invokes onProgressUpdate();
                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            result *= values[0].intValue(); //
            if (values[0].intValue() == num)
                Text1.setText(String.valueOf(values[0].intValue()));
            else
                Text2.append("   " + String.valueOf(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void aVoid) { // when the thread is finished
            Text2.setText("= " + String.valueOf(result));
        }

    }
}

