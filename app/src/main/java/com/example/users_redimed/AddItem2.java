package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddItem2 extends AppCompatActivity {

    Button btFinish;
    int countItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item2);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }

        //ánh xạ
        btFinish = (Button) findViewById(R.id.btFinishId);
        countItem ++;
        //code
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(AddItem2.this,RequestAdvice.class);
                it.putExtra("CI",countItem);
                startActivity(it);

            }
        });

    }
}
