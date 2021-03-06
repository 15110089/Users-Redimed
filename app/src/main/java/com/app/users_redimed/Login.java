package com.app.users_redimed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.iid.FirebaseInstanceId;

public class Login extends AppCompatActivity {
    Button btLogin;
    TextView tvSignUp;
    TextView txtPhone;
    TextView txtPass;
    Database databasel;
    int countItem = 0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    //    User u = new User("","","");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ánh xạ
        btLogin = (Button) findViewById(R.id.btLoginId);
        tvSignUp = (TextView) findViewById(R.id.tvSignUpId);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtPass = (TextView) findViewById(R.id.txtPass);
        databasel = new Database(this,"redimed.sqlite",null,1);

        //code
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = txtPhone.getText().toString();
                myRef.child("Patient").child(key).child("Profile").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                        User u = dataSnapshot.getValue(User.class);
                        try
                        {
                            String passWord = u.Pass;
                            if(passWord.equals(""))
                            { }
                            else
                            {
                                if(txtPass.getText().toString().equals(passWord))
                                {
                                    Intent it  =new Intent(Login.this,Option.class);
                                    //create table
                                    String key = txtPhone.getText().toString();
                                    myRef.child("Patient").child(key).child("Profile").child("Token").setValue(FirebaseInstanceId.getInstance().getToken());

                                    databasel.QueryData("CREATE TABLE IF NOT EXISTS TabelUser(Id INTEGER PRIMARY KEY, Email VARCHAR(200))");
                                    Cursor itemTests = databasel.GetData("SELECT * FROM TabelUser");
                                    while (itemTests.moveToNext()){
                                        databasel.QueryData("UPDATE TabelUser SET Email ='"+ u.Phone +"' WHERE Id = 1");
                                        it.putExtra("CI",countItem);
                                        startActivity(it);
                                        return;
                                    }
                                    databasel.QueryData("INSERT INTO TabelUser VALUES(1,'"+u.Phone+"')");
                                    it.putExtra("CI",countItem);
                                    startActivity(it);
                                    return;
                                }
                                else
                                {
                                    Toast.makeText(Login.this, "Phone hoặc Password không đúng", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(Login.this, "Phone hoặc Password không đúng", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
//                myRef.child("Patient").child(key).child("Profile").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for (DataSnapshot node : dataSnapshot.getChildren()) {
//                            User u = node.getValue(User.class);
//                            if(u.Email.equals(txtEmail.getText().toString())&&u.Pass.equals(txtPass.getText().toString())){
//                                Intent it  =new Intent(Login.this,Option.class);
//
//                                //create table
//                                databasel.QueryData("CREATE TABLE IF NOT EXISTS TabelUser(Id INTEGER PRIMARY KEY, Email VARCHAR(200))");
//                                Cursor itemTests = databasel.GetData("SELECT * FROM TabelUser");
//                                while (itemTests.moveToNext()){
//                                    databasel.QueryData("UPDATE TabelUser SET Email ='"+ u.Email +"' WHERE Id = 1");
//                                    it.putExtra("CI",countItem);
//                                        startActivity(it);
//                                    return;
//                                }
//                                databasel.QueryData("INSERT INTO TabelUser VALUES(1,'"+u.Email+"')");
//                                it.putExtra("CI",countItem);
//                                startActivity(it);
//                                return;
//
//                            }
//                        }
//                        Toast.makeText(Login.this, "Email hoặc Password không đúng", Toast.LENGTH_LONG).show();
//                    }
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        Toast.makeText(Login.this, "Email hoặc Password không đúng", Toast.LENGTH_LONG).show();
//                    }
//                });


            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Login.this,SignUpStep1.class);
                startActivity(it);

            }
        });
        //log root
        rootData model = ViewModelProviders.of(this).get(rootData.class);
        //post
//         u.name = "nghia2";
//         u.sdt = "098";
//         u.id = "002";
//         model.setUser(u);




    }
}
