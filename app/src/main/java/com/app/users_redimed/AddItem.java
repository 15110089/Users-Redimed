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
    TextView testLocal;
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
        testLocal = (TextView) findViewById(R.id.testLocal);
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

                int pX = (touchX * 100) / imgBody.getMeasuredWidth();
                int pY = (touchY * 100) / imgBody.getMeasuredHeight();

                int imageX = touchX - viewCoords[0]; // posXY[0] is the X coordinate
                int imageY = touchY - viewCoords[1]; // posXY[1] is the y coordinate

                Log.i(">X<",String.valueOf(touchX));
                Log.i(">Y<",String.valueOf(touchY));

                int iX = imageX * 1000 / imgBody.getMeasuredHeight();
                int iY = imageY * 1000 / imgBody.getMeasuredWidth();

//                Log.i(">X<", "============");
//                Log.i(">X<", String.valueOf(iX));
//                Log.i(">Y<", String.valueOf(iY));
//                Log.i(">Y<", "============");
                String testLocalstring = "";
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
//                if (bodyFace == 1) {
//                    if (-395 < iX && iX < -318 && -1102 < iY && iY < -381) {
//                        Log.i(">local<:", "1");
//                        localBody = "Right Hand";
//                        imgBody.setImageResource(R.drawable.body_f_1);
//                        testLocal.setText(testLocalstring);
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-128 < iX && iX < -22 && -1120 < iY && iY < -381) {
//                        Log.i(">local<:", "2");
//                        localBody = "Left Hand";
//                        imgBody.setImageResource(R.drawable.body_f_2);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-308 < iX && iX < -128 && -1120 < iY && iY < -598) {
//                        Log.i(">local<:", "3");
//                        localBody = "Body";
//                        imgBody.setImageResource(R.drawable.body_f_3);
//                       testLocal.setText("X:"+String.valueOf(iX)+" Y:"+String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-313 < iX && iX < -230 && -462 < iY && iY < 411) {
//                        Log.i(">local<:", "4");
//                        localBody = "Right Foot";
//                        imgBody.setImageResource(R.drawable.body_f_4);
//                       testLocal.setText("X:"+String.valueOf(iX)+" Y:"+String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-211 < iX && iX < -128 && -488 < iY && iY < 419) {
//                        Log.i(">local<:", "5");
//                        localBody = "Left Foot";
//                        imgBody.setImageResource(R.drawable.body_f_5);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-264 < iX && iX < -191 && -1381 < iY && iY < -1209) {
//                        Log.i(">local<:", "6");
//                        localBody = "Head";
//                        imgBody.setImageResource(R.drawable.body_f_6);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                } else {
//
//                    //Back
//                    if (-405 < iX && iX < -293 && -1127 < iY && iY < -363) {
//                        Log.i(">local<:", "1");
//                        localBody = "Right Hand";
//                        imgBody.setImageResource(R.drawable.body_b_1);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-118 < iX && iX < -41 && -1138 < iY && iY < -398) {
//                        Log.i(">local<:", "2");
//                        localBody = "Left Hand";
//                        imgBody.setImageResource(R.drawable.body_b_2);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-299 < iX && iX < -114 && -1127 < iY && iY < -562) {
//                        Log.i(">local<:", "3");
//                        localBody = "Body";
//                        imgBody.setImageResource(R.drawable.body_b_3);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-299 < iX && iX < -206 && -498 < iY && iY < 411) {
//                        Log.i(">local<:", "4");
//                        localBody = "Right Foot";
//                        imgBody.setImageResource(R.drawable.body_b_4);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-216 < iX && iX < -114 && -506 < iY && iY < 419) {
//                        Log.i(">local<:", "5");
//                        localBody = "Left Foot";
//                        imgBody.setImageResource(R.drawable.body_b_5);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                    if (-245 < iX && iX < -158 && -1388 < iY && iY < -1209) {
//                        Log.i(">local<:", "6");
//                        localBody = "Head";
//                        imgBody.setImageResource(R.drawable.body_b_6);
//                        testLocal.setText("X:" + String.valueOf(iX) + " Y:" + String.valueOf(iY));
//                        testLocalstring = testLocalstring + localBody;
//                    }
//                }

                if (bodyFace == 1) {
                    if (11 < pX && pX < 28 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_f_1);
                        testLocal.setText(testLocalstring);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (64 < pX && pX < 84 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_f_2);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (28 < pX && pX < 64 && 15 < pY && pY < 44) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_f_3);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (28 < pX && pX < 47 && 43 < pY && pY < 98) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_f_4);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (47 < pX && pX < 61 && 41 < pY && pY < 99) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_f_5);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (37 < pX && pX < 54 && 1 < pY && pY < 11) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_f_6);
                        testLocalstring = testLocalstring + localBody;
                    }
                } else {

                    //Back
                    if (-405 < touchX && touchX < -293 && -1127 < pY && pY < -363) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_b_1);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (-118 < touchX && touchX < -41 && -1138 < touchY && touchY < -398) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_b_2);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (-299 < touchX && touchX < -114 && -1127 < touchY && touchY < -562) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_b_3);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (-299 < touchX && touchX < -206 && -498 < touchY && touchY < 411) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_b_4);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (-216 < touchX && touchX < -114 && -506 < touchY && touchY < 419) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_b_5);
                        testLocalstring = testLocalstring + localBody;
                    }
                    if (-245 < touchX && touchX < -158 && -1388 < touchY && touchY < -1209) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_b_6);
                        testLocalstring = testLocalstring + localBody;
                    }
                }

                testLocal.setText("X:" + String.valueOf(pX) + " Y:" + String.valueOf(pY) + " " + testLocalstring);


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
