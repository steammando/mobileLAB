package com.example.leng.lab32;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent passedintent = getIntent();
        Bundle mybundle=passedintent.getExtras();
        TextView tex1 = findViewById(R.id.text1);
        TextView tex2 = findViewById(R.id.text2);
        TextView tex3 = findViewById(R.id.text3);
        Button bt = findViewById(R.id.btn2);
        String m1 = mybundle.getString("msg1");
        String m2 = mybundle.getString("msg2");
        String m3 = mybundle.getString("msg3");
        tex1.setText(m1);
        tex2.setText(m2);
        tex3.setText(m3);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
