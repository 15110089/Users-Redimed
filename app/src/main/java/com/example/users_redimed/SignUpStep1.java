package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStep1 extends AppCompatActivity {

    Button btSignUps1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step1);

        //ánh xạ
        btSignUps1 = (Button) findViewById(R.id.btSignUpt1Id);
        //code
        btSignUps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep1.this,SignUpStep2.class);
                startActivity(it);
            }
        });
    }
}
