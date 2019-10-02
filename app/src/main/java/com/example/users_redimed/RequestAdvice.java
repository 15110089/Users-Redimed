package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RequestAdvice extends AppCompatActivity {

    Button btAddItem;
    Button btSend;
    CardView crItem1;
    CardView crItem2;
    CardView crItem3;
    CardView crItem4;

    TextView txtNotItem;
    int countItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_advice);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }

        //ánh xạ
        btAddItem = (Button) findViewById(R.id.btAddItemId);
        btSend = (Button) findViewById(R.id.btSendId);
        crItem1 = (CardView) findViewById(R.id.crItem1Id);
        crItem2 = (CardView) findViewById(R.id.crItem2Id);
        crItem3 = (CardView) findViewById(R.id.crItem3Id);
        crItem4 = (CardView) findViewById(R.id.crItem4Id);
        txtNotItem = (TextView) findViewById(R.id.txtNotItemId);
        //code
        btAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it  =new Intent(RequestAdvice.this,AddItem.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });
        if(countItem>0){
            crItem1.setVisibility(View.VISIBLE);
            txtNotItem.setVisibility(View.INVISIBLE);
            btSend.setVisibility(View.VISIBLE);
        }
        if(countItem>1){
            crItem2.setVisibility(View.VISIBLE);
        }
        if(countItem>2){
            crItem3.setVisibility(View.VISIBLE);
        }
        if(countItem>3){
            crItem4.setVisibility(View.VISIBLE);
        }



    }
}
