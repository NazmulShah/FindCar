package com.example.user.findcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 12/30/2015.
 */
public class FindCarActivity extends Activity {

    Button showphoto,nevigation;
    TextView textfind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findcar);

        textfind=(TextView)findViewById(R.id.tv_findcar);

        nevigation=(Button)findViewById(R.id.bt_nevigate);
        showphoto=(Button)findViewById(R.id.bt_showphoto);

        showphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FindCarActivity.this,ImagePickActivity.class);
                startActivity(i);
            }
        });


    }
}
