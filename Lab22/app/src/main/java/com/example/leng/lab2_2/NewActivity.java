package com.example.leng.lab2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView) findViewById(R.id.textView);
        goBtn = (Button) findViewById(R.id.goBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("Url");
        textView.setText(passedUrl);

        goBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter address again", Toast.LENGTH_LONG).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pressed back button", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}