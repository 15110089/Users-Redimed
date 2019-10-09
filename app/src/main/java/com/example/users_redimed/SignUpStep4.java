package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStep4 extends AppCompatActivity {

    Button btSignUps4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step4);
        //ánh xạ
        btSignUps4 = (Button) findViewById(R.id.btSignUpt4Id);
        //code
        btSignUps4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep4.this,SignUpStep5.class);
                startActivity(it);
            }
        });
    }
}
