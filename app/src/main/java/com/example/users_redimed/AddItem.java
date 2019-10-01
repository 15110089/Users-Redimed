package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

    Spinner spRegionBody;
    Button btNextAddItem1;
    int countItem;
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
        spRegionBody = (Spinner) findViewById(R.id.spRegionBodyId);
        btNextAddItem1 = (Button) findViewById(R.id.btAddItem1Id);

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
                Intent it  =new Intent(AddItem.this,AddItem1.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });

    }
}
