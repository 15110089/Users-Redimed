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

                String localBody = "";


                if (bodyFace == 1) {
                    if (11 < pX && pX < 28 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_f_1);
                    }
                    if (64 < pX && pX < 84 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_f_2);
                    }
                    if (28 < pX && pX < 64 && 15 < pY && pY < 44) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_f_3);
                    }
                    if (28 < pX && pX < 47 && 43 < pY && pY < 98) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_f_4);
                    }
                    if (47 < pX && pX < 61 && 41 < pY && pY < 99) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_f_5);
                    }
                    if (37 < pX && pX < 54 && 1 < pY && pY < 11) {
                        Log.i(">local<:", "6");
                        localBody = "Head";
                        imgBody.setImageResource(R.drawable.body_f_6);
                    }
                } else {

                    //Back
                    if (66 < pX && pX < 83 && 15 < pY && pY < 55) {
                        Log.i(">local<:", "2");
                        localBody = "Left Hand";
                        imgBody.setImageResource(R.drawable.body_b_2);
                    }
                    if (11 < pX && pX < 32 && 16 < pY && pY < 56) {
                        Log.i(">local<:", "1");
                        localBody = "Right Hand";
                        imgBody.setImageResource(R.drawable.body_b_1);
                    }
                    if (31 < pX && pX < 66 && 15 < pY && pY < 41) {
                        Log.i(">local<:", "3");
                        localBody = "Body";
                        imgBody.setImageResource(R.drawable.body_b_3);
                    }
                    if (49 < pX && pX < 67 && 42 < pY && pY < 98) {
                        Log.i(">local<:", "5");
                        localBody = "Left Foot";
                        imgBody.setImageResource(R.drawable.body_b_5);
                    }
                    if (31 < pX && pX < 48 && 42 < pY && pY < 98) {
                        Log.i(">local<:", "4");
                        localBody = "Right Foot";
                        imgBody.setImageResource(R.drawable.body_b_4);
                    }
                    if (42 < pX && pX < 59 && 1 < pY && pY < 11) {
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
