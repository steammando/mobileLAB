package com.example.leng.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radio;
    RadioButton chkman;
    RadioButton chkwoman;
    CheckBox chksms;
    CheckBox chkemail;
    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio = (RadioGroup) findViewById(R.id.radio);
        chkman = (RadioButton) findViewById(R.id.man);
        chkwoman = (RadioButton) findViewById(R.id.woman);
        chksms = findViewById(R.id.sms);
        chkemail = findViewById(R.id.email);
        text = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg1 = "";
                String msg2 = "";
                String msg3 = "";
                msg1 += text.getText();
                int radioid = radio.getCheckedRadioButtonId();
                if (chkman.getId() == radioid)
                    msg2 += "male";
                if (chkwoman.getId() == radioid)
                    msg2 += "female";
                if (chksms.isChecked()) {
                    msg3 += "SMS";
                }
                if (chkemail.isChecked()) {
                    msg3 += "EMAIL";
                }

                Intent intent =new Intent(getApplicationContext(),NewActivity.class);
                Bundle mybundle = new Bundle();
                mybundle.putString("msg1", msg1);
                mybundle.putString("msg2", msg2);
                mybundle.putString("msg3", msg3);
                intent.putExtras(mybundle);
                startActivity(intent);
                finish();
            }
        });
    }
}
