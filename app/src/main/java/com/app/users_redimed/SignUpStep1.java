package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SignUpStep1 extends AppCompatActivity {

    TextView txtName;
    Spinner txtGender;
    TextView txtBirth;
    TextView txtEmail;
    Button btSignUps1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step1);

        //ánh xạ
        btSignUps1 = (Button) findViewById(R.id.btSignUpt1Id);
        txtName = (TextView) findViewById(R.id.txtName);
        txtGender = (Spinner) findViewById(R.id.txtGender);
        txtBirth = (TextView) findViewById(R.id.txtBirth);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        List<String> list = new ArrayList<>();
        list.add("Male");
        list.add("Female");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        txtGender.setAdapter(adapter);
        //code
        btSignUps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(SignUpStep1.this,SignUpStep2.class);
                it.putExtra("name",txtName.getText().toString());
                it.putExtra("gender",txtGender.getSelectedItem().toString());
                it.putExtra("birth",txtBirth.getText().toString());
                it.putExtra("email",txtEmail.getText().toString());
                startActivity(it);
            }
        });
    }
}
