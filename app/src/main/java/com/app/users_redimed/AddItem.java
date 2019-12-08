package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddItem extends AppCompatActivity {

    Spinner spRegionBody;
    EditText txtName;
    Button btNextAddItem1;
    Button btChange;
    ImageView imgBody;
    int countItem;
    Database databasel;
    int bodyFace = 1;

    @SuppressLint("ClickableViewAccessibility")
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
        btChange = (Button) findViewById(R.id.btChange);
        imgBody = (ImageView) findViewById(R.id.imgBody);
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

        imgBody.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int[] viewCoords = new int[2];
                imgBody.getLocationOnScreen(viewCoords);

                int touchX = (int) event.getX();
                int touchY = (int) event.getY();

                Log.i(">X<",String.valueOf(touchX));
                Log.i(">Y<",String.valueOf(touchY));

                if(46<touchX&&touchX<113&&271<touchY&&touchY<415){
                    Log.i(">local<:","5");
                }
                if(46<touchX&&touchX<113&&127<touchY&&touchY<271){
                    Log.i(">local<:","6");
                }

                if(127<touchX&&touchX<189&&116<touchY&&touchY<234){
                    Log.i(">local<:","1");
                }
                if(189<touchX&&touchX<251&&116<touchY&&touchY<234){
                    Log.i(">local<:","2");
                }
                if(127<touchX&&touchX<189&&234<touchY&&touchY<352){
                    Log.i(">local<:","3");
                }
                if(189<touchX&&touchX<251&&234<touchY&&touchY<352){
                    Log.i(">local<:","4");
                }

                if(247<touchX&&touchX<335&&112<touchY&&touchY<263){
                    Log.i(">local<:","7");
                }
                if(247<touchX&&touchX<335&&263<touchY&&touchY<415){
                    Log.i(">local<:","8");
                }

                if(110<touchX&&touchX<184&&373<touchY&&touchY<547){
                    Log.i(">local<:","9");
                }
                if(110<touchX&&touchX<184&&547<touchY&&touchY<721){
                    Log.i(">local<:","10");
                }

                if(191<touchX&&touchX<254&&380<touchY&&touchY<550){
                    Log.i(">local<:","11");
                }
                if(191<touchX&&touchX<254&&550<touchY&&touchY<721){
                    Log.i(">local<:","12");
                }

                if(152<touchX&&touchX<205&&10<touchY&&touchY<88){
                    Log.i(">local<:","13");
                }

                return true;
            }

         });
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bodyFace == 1){
                    imgBody.setImageResource(R.drawable.bodyback);
                    bodyFace = 0;
                }else{
                    imgBody.setImageResource(R.drawable.bodyface);
                    bodyFace = 1;
                }
            }
        });

    }


}
