package com.example.leng.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edit_name;

    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        edit_name = (EditText)findViewById(R.id.entry);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_print = (Button)findViewById(R.id.btn_print);
        view_print = (TextView)findViewById(R.id.result);
    }//Call all value

    public void clearClicked(View v) {
        edit_name.setText("");
        view_print.setText("");
    }//If clear button has clicked, set text to ""

    public void printClicked(View v) {
        view_print.setText(edit_name.getText().toString());
    }//If print button has clicked, set text by input string
}
