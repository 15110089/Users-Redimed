package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStep3 extends AppCompatActivity {

    Button btSignUps3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step3);

        //ánh xạ
        btSignUps3 = (Button) findViewById(R.id.btSignUpt3Id);
        //code
        btSignUps3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep3.this,SignUpStep4.class);
                startActivity(it);
            }
        });
    }
}
