package com.example.users_redimed;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.lifecycle.ViewModelProviders;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import java.io.File;

public class Login extends AppCompatActivity {

    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ánh xạ
        btLogin = (Button) findViewById(R.id.btLoginId);

        //code
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Login.this,Option.class);
                startActivity(it);
            }
        });
        //log root
        rootData model = ViewModelProviders.of(this).get(rootData.class);


        Log.i(">N", model.getUsers());
    }
}
