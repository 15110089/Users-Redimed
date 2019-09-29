package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddItem1 extends AppCompatActivity {

    Button btAddItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item1);
        //ánh xạ
        btAddItem2 = (Button) findViewById(R.id.btAddItem2Id);

        //code
        btAddItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(AddItem1.this,AddItem2.class);
                startActivity(it);
            }
        });
    }
}
