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

        import com.example.users_redimed.Model.User;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.io.File;

public class Login extends AppCompatActivity {
    Button btLogin;
    TextView tvSignUp;
    int countItem = 0;
    User u = new User("","","");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ánh xạ
        btLogin = (Button) findViewById(R.id.btLoginId);
        tvSignUp = (TextView) findViewById(R.id.tvSignUpId);

        //code
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Login.this,Option.class);
                it.putExtra("CI",countItem);
                startActivity(it);
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
