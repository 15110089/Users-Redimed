package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

    Spinner spRegionBody;
    EditText txtName;
    Button btNextAddItem1;
    int countItem;
    Database databasel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }
        //ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        //databasel.QueryData("drop table 'TabelName'");
        databasel.QueryData("CREATE TABLE IF NOT EXISTS TabelName(Id INTEGER PRIMARY KEY, Region VARCHAR(500))");
        spRegionBody = (Spinner) findViewById(R.id.spRegionBodyId);
        txtName = (EditText) findViewById(R.id.txtName);
        btNextAddItem1 = (Button) findViewById(R.id.btAddItem1Id);
        databasel.QueryData("DELETE FROM TabelName WHERE Id = 1");
        //code
        List<String> list = new ArrayList<>();
        list.add("Region left back");
        list.add("Region right back");
        list.add("Region left front");
        list.add("Region right front");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spRegionBody.setAdapter(adapter);
        btNextAddItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databasel.QueryData("INSERT INTO TabelName VALUES(1,'"+spRegionBody.getSelectedItem().toString()+"')");
                Intent it  =new Intent(AddItem.this,AddItem1.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });

    }
}
