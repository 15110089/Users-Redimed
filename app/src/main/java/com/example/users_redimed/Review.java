package com.example.users_redimed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Review extends AppCompatActivity {

    ImageView Img1;
    Button btSend;
    Database databasel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        btSend = (Button) findViewById(R.id.btSendId);
        Img1 = (ImageView) findViewById(R.id.idImg1);
        //code
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(Review.this,Option.class);
                startActivity(it);
            }
        });
        //Get id
        Cursor itemTest = databasel.GetData("SELECT * FROM TabelImage1 WHERE Id = 1");
        while (itemTest.moveToNext()){
            String Image = itemTest.getString(1);
            Img1.setImageBitmap(StringToBitMap(Image));

        }

    }

    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }



}


