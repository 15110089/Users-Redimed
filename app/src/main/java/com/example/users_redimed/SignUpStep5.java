package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStep5 extends AppCompatActivity {

    Button btSignUps5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step5);
        //ánh xạ
        btSignUps5 = (Button) findViewById(R.id.btSignUpt5Id);
        //code
        btSignUps5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep5.this,Login.class);
                startActivity(it);
            }
        });
    }
}
