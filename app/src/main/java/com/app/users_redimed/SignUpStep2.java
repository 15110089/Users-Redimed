package com.app.users_redimed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.users_redimed.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpStep2 extends AppCompatActivity {

    Button btSignUps2;
    TextView txtPhone;
    TextView txtPass;
    TextView txtConfirmPass;
    String bdTxtName;
    String bdTxtGender;
    String bdTxtBirth;
    String bdTxtEmail;
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
            bdTxtEmail = bd.getString("email");
        }

        //ánh xạ
        btSignUps2 = (Button) findViewById(R.id.btSignUpt2Id);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtPass = (TextView) findViewById(R.id.txtPass);
        txtConfirmPass = (TextView) findViewById(R.id.txtConfirmPass);
        //code
        btSignUps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPass.getText().toString().equals(txtConfirmPass.getText().toString())) {

                    myRef.child("Patient").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            int tao = 1;
                            for (DataSnapshot node : dataSnapshot.getChildren()) {
                                String u = node.getKey();
                                if (u.equals(txtPhone.getText().toString())) {
                                    Toast.makeText(SignUpStep2.this, "Phone đã được đăng ký", Toast.LENGTH_SHORT).show();
                                    tao = 0;
                                }
                            }
                            if (tao == 1) {
                                try{
                                    user.Name = bdTxtName;
                                    user.Gender = bdTxtGender;
                                    user.Birth = bdTxtBirth;
                                    user.Email = bdTxtEmail;
                                    user.Phone = txtPhone.getText().toString();
                                    user.Pass = txtPass.getText().toString();
                                    String key = txtPhone.getText().toString();

                                    myRef.child("Patient").child(key).child("Profile").setValue(user);
                                    Intent it = new Intent(SignUpStep2.this, Login.class);
                                    startActivity(it);
                                }
                                catch(Exception e) {
                                    Toast.makeText(SignUpStep2.this, "Phone Không hợp lệ", Toast.LENGTH_SHORT).show();
                                }
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
