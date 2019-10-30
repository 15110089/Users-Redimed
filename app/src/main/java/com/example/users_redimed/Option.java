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
    Button btls;
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
        btls = (Button) findViewById(R.id.btls);
        databasel = new Database(this,"redimed.sqlite",null,1);
        //code
        btRequestAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Option.this,AddRequestAndTrack.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });
        btls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Option.this,LichSu1Activity.class);
                startActivity(it);
            }
        });

        //Get id
        Cursor itemTest = databasel.GetData("SELECT * FROM TabelUser WHERE Id = 1");
        while (itemTest.moveToNext()){
            String TEN2 = itemTest.getString(1);
            Log.i(">12<", TEN2);
        }
    }
}
