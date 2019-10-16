package com.example.users_redimed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.users_redimed.Model.User;
import com.example.users_redimed.SetData.SeterUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpStep2 extends AppCompatActivity {

    Button btSignUps2;
    TextView txtEmail;
    TextView txtPass;
    TextView txtConfirmPass;
    String bdTxtName;
    String bdTxtGender;
    String bdTxtBirth;
    String bdTxtPhone;
    User user = new User("","","","","","");
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step2);
        //post
        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            bdTxtName = bd.getString("name");
            bdTxtGender = bd.getString("gender");
            bdTxtBirth = bd.getString("birth");
            bdTxtPhone = bd.getString("phone");
        }

        //ánh xạ
        btSignUps2 = (Button) findViewById(R.id.btSignUpt2Id);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPass = (TextView) findViewById(R.id.txtPass);
        txtConfirmPass = (TextView) findViewById(R.id.txtConfirmPass);
        //code
        btSignUps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPass.getText().toString().equals(txtConfirmPass.getText().toString())) {

                    myRef.child("User").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            int tao = 1;
                            for (DataSnapshot node : dataSnapshot.getChildren()) {

                                User u = node.getValue(User.class);
                                if (u.Email.equals(txtEmail.getText().toString())) {
                                    Toast.makeText(SignUpStep2.this, "Email đã được đăng ký vui lòng dung Email khác", Toast.LENGTH_LONG).show();
                                    tao = 0;
                                }
                            }
                            if (tao == 1) {
                                user.Name = bdTxtName;
                                user.Gender = bdTxtGender;
                                user.Birth = bdTxtBirth;
                                user.Phone = bdTxtPhone;
                                user.Email = txtEmail.getText().toString();
                                user.Pass = txtPass.getText().toString();
                                myRef.child("User").push().setValue(user);
                                Intent it = new Intent(SignUpStep2.this, Login.class);
                                startActivity(it);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
                } else {
                    Toast.makeText(SignUpStep2.this, "Password và Confirm Password không trùng khớp", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
