package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestAdvice extends AppCompatActivity {

    Button btAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_advice);
        //ánh xạ
        btAddItem = (Button) findViewById(R.id.btAddItemId);

        //code
        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(RequestAdvice.this,AddItem.class);
                startActivity(it);
            }
        });
    }
}
