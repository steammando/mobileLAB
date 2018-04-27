package com.example.leng.lab31;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn=findViewById(R.id.button); // get button id address
        registerForContextMenu(mBtn); // receive the view to witch the context menu should be associated
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Button Menu"); // set menu title
        menu.add(0,1,0,"Red"); // add  red to first in menu
        menu.add(0,2,1,"Green"); // add green to second in menu
        menu.add(0,3,2,"Blue"); // add Blue to third in menu
    }

    public boolean onContextItemSelected(MenuItem item){
        int id=item.getItemId(); // get id of checked button

        if(id==1)
            mBtn.setTextColor(Color.RED); // convert text color to red
        if(id==2)
            mBtn.setTextColor(Color.GREEN); // convert text color to green
        if(id==3)
            mBtn.setTextColor(Color.BLUE); // convert text color to blue

        return true;
    }
}
