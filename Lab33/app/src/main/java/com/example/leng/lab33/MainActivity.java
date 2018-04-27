package com.example.leng.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button frag1;
    Button frag2;

    fragment1 fragment1;
    fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setListener();

    }

    public void init(){
        frag1=findViewById(R.id.tab1); // get button id from XML
        frag2=findViewById(R.id.tab2); // get button id from XML
        fragment1=new fragment1(); // create new fragment
        fragment2=new fragment2(); // create new fragment
    }

    public void setListener(){
        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); // visible fragment1
            }
        });

        frag2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit(); // visible fragment2
            }
        });
    }
}
