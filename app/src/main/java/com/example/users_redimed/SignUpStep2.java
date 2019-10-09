package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStep2 extends AppCompatActivity {

    Button btSignUps2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step2);

        //ánh xạ
        btSignUps2 = (Button) findViewById(R.id.btSignUpt2Id);
        //code
        btSignUps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep2.this,SignUpStep3.class);
                startActivity(it);
            }
        });
    }
}
