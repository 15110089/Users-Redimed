package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddRequestAndTrack extends AppCompatActivity {

    Button btAddItem;
    Button btTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request_and_track);
        btAddItem = (Button) findViewById(R.id.btAddItem);
        btTrack = (Button) findViewById(R.id.btTrack);
        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(AddRequestAndTrack.this,AddItem.class);
                startActivity(it);
            }
        });
        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(AddRequestAndTrack.this,RequestSent.class);
                startActivity(it);
            }
        });

    }
}
