package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Option extends AppCompatActivity {

    Button btRequestAdvice;
    int countItem;
    Database databasel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }

        //ánh xạ
        btRequestAdvice = (Button) findViewById(R.id.btRequestAdviceId);
        databasel = new Database(this,"redimed.sqlite",null,1);
        //code
        btRequestAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Option.this,AddItem.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });

        //Get id
        Cursor itemTest = databasel.GetData("SELECT * FROM TabelUser WHERE Id = 1");
        while (itemTest.moveToNext()){
            String TEN2 = itemTest.getString(1);
            Log.i("><", TEN2);
        }
    }
}
