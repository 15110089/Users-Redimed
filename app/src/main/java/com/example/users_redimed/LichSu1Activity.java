package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LichSu1Activity extends AppCompatActivity {

    Button btrv;
    Database databasel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su1);
        //ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        btrv = (Button) findViewById(R.id.btrv);
        //code
        btrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(LichSu1Activity.this,LichSu2Activity.class);
                startActivity(it);
            }
        });
        Cursor itemName = databasel.GetData("SELECT * FROM TabelName WHERE Id = 1");
        while (itemName.moveToNext()){
            btrv.setText(itemName.getString(1));
        }
    }
}
