package com.app.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class AddItem extends AppCompatActivity {

    Spinner spRegionBody;
    EditText txtName;
    Button btNextAddItem1;
    Button btChange;
    ImageView imgBody;
    TextView txtLocalBody;
    int countItem;
    Database databasel;
    int bodyFace = 1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            countItem = bd.getInt("CI");
        }
        //ánh xạ
        databasel = new Database(this, "redimed.sqlite", null, 1);
        //databasel.QueryData("drop table 'TabelName'");
        databasel.QueryData("CREATE TABLE IF NOT EXISTS TabelName(Id INTEGER PRIMARY KEY, Region VARCHAR(500))");
//        spRegionBody = (Spinner) findViewById(R.id.spRegionBodyId);
        txtName = (EditText) findViewById(R.id.txtName);
        btNextAddItem1 = (Button) findViewById(R.id.btAddItem1Id);
        txtLocalBody = (TextView) findViewById(R.id.txtLocalBody);
        btChange = (Button) findViewById(R.id.btChange);
        imgBody = (ImageView) findViewById(R.id.imgBody);
        databasel.QueryData("DELETE FROM TabelName WHERE Id = 1");
        //code
//        List<String> list = new ArrayList<>();
//        list.add("Region left back");
//        list.add("Region right back");
//        list.add("Region left front");
//        list.add("Region right front");
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
//        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
//        spRegionBody.setAdapter(adapter);
        btNextAddItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databasel.QueryData("INSERT INTO TabelName VALUES(1,'" + txtLocalBody.getText().toString() + "')");
                Intent it = new Intent(AddItem.this, AddItem1.class);
                it.putExtra("CI", countItem);
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

                int imageX = touchX - viewCoords[0]; // posXY[0] is the X coordinate
                int imageY = touchY - viewCoords[1]; // posXY[1] is the y coordinate

//                Log.i(">X<",String.valueOf(touchX));
//                Log.i(">Y<",String.valueOf(touchY));

                int iX = imageX * 1000 / imgBody.getMeasuredHeight();
                int iY = imageY * 1000 / imgBody.getMeasuredWidth();

                Log.i(">X<", "============");
                Log.i(">X<", String.valueOf(iX));
                Log.i(">Y<", String.valueOf(iY));
                Log.i(">Y<", "============");

                String localBody = "";
                int khongTrong = 40;
//                if(46<touchX&&touchX<113&&271<touchY&&touchY<415){
//                    Log.i(">local<:","5");
//                    localBody = "Left Forearm";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_5);
//                    }
//                }
//                if(46<touchX&&touchX<113&&127<touchY&&touchY<271){
//                    Log.i(">local<:","6");
//                    localBody = "Left Arm";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_6);
//                    }
//                }
//
//                if(127<touchX&&touchX<189&&116<touchY&&touchY<234){
//                    Log.i(">local<:","1");
//                    localBody = "Left Chest";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_1);
//                    }
//                }
//                if(189<touchX&&touchX<251&&116<touchY&&touchY<234){
//                    Log.i(">local<:","2");
//                    localBody = "Right Chest";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_2);
//                    }
//                }
//                if(127<touchX&&touchX<189&&234<touchY&&touchY<352){
//                    Log.i(">local<:","3");
//                    localBody = "Left Abdomen";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_3);
//                    }
//                }
//                if(189<touchX&&touchX<251&&234<touchY&&touchY<352){
//                    Log.i(">local<:","4");
//                    localBody = "Right Abdomen";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_4);
//                    }
//                }
//
//                if(247<touchX&&touchX<335&&112<touchY&&touchY<263){
//                    Log.i(">local<:","7");
//                    localBody = "Right Arm";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_7);
//                    }
//                }
//                if(247<touchX&&touchX<335&&263<touchY&&touchY<415){
//                    Log.i(">local<:","8");
//                    localBody = "Right Forearm";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_8);
//                    }
//                }
//
//                if(110<touchX&&touchX<184&&373<touchY&&touchY<547){
//                    Log.i(">local<:","9");
//                    localBody = "Left Thigh";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_9);
//                    }
//                }
//                if(110<touchX&&touchX<184&&547<touchY&&touchY<721){
//                    Log.i(">local<:","10");
//                    localBody = "Left Calf";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_10);
//                    }
//                }
//
//                if(191<touchX&&touchX<254&&380<touchY&&touchY<550){
//                    Log.i(">local<:","11");
//                    localBody = "Right Thigh";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_11);
//                    }
//
//                }
//                if(191<touchX&&touchX<254&&550<touchY&&touchY<721){
//                    Log.i(">local<:","12");
//                    localBody = "Right Calf";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_12);
//                    }
//                }
//
//                if(152<touchX&&touchX<205&&10<touchY&&touchY<88){
//                    Log.i(">local<:","13");
//                    localBody = "Head";
//                    if(bodyFace == 1){
//                        imgBody.setImageResource(R.drawable.body_f_13);
//                    }
//                }


                //front
                if (bodyFace == 1) {
                    if (-395 + khongTrong < iX && iX < -318 + khongTrong && -1102 + khongTrong < iY && iY < -381 + khongTrong) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_f_1);
                    }
                    if (-128 + khongTrong < iX && iX < -22 + khongTrong && -1120 + khongTrong < iY && iY < -381 + khongTrong) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_f_2);
                    }
                    if (-308 + khongTrong < iX && iX < -128 + khongTrong && -1120 + khongTrong < iY && iY < -598 + khongTrong) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_f_3);
                    }
                    if (-313 + khongTrong < iX && iX < -230 + khongTrong && -462 + khongTrong < iY && iY < 411 + khongTrong) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_f_4);
                    }
                    if (-211 + khongTrong < iX && iX < -128 + khongTrong && -488 + khongTrong < iY && iY < 419 + khongTrong) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_f_5);
                    }
                    if (-264 + khongTrong < iX && iX < -191 + khongTrong && -1381 + khongTrong < iY && iY < -1209 + khongTrong) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_f_6);
                    }
                } else {

                    //Back
                    if (-405 + khongTrong < iX && iX < -293 + khongTrong && -1127 + khongTrong < iY && iY < -363 + khongTrong) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_b_1);
                    }
                    if (-118 + khongTrong < iX && iX < -41 + khongTrong && -1138 + khongTrong < iY && iY < -398 + khongTrong) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_b_2);
                    }
                    if (-299 + khongTrong < iX && iX < -114 + khongTrong && -1127 + khongTrong < iY && iY < -562 + khongTrong) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_b_3);
                    }
                    if (-299 + khongTrong < iX && iX < -206 + khongTrong && -498 + khongTrong < iY && iY < 411 + khongTrong) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_b_4);
                    }
                    if (-216 + khongTrong < iX && iX < -114 + khongTrong && -506 + khongTrong < iY && iY < 419 + khongTrong) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_b_5);
                    }
                    if (-245 + khongTrong < iX && iX < -158 + khongTrong && -1388 + khongTrong < iY && iY < -1209 + khongTrong) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_b_6);
                    }
                }


                if (bodyFace == 1) {
                    if (localBody != "")
                        txtLocalBody.setText(localBody + " Front");
                } else {
                    if (localBody != "")
                        txtLocalBody.setText(localBody + " Back");
                }

                return true;
            }

        });
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bodyFace == 1) {
                    imgBody.setImageResource(R.drawable.bodyback);
                    bodyFace = 0;
                } else {
                    imgBody.setImageResource(R.drawable.bodyface);
                    bodyFace = 1;
                }
            }
        });


    }


}
