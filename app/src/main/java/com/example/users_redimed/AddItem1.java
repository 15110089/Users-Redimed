package com.example.users_redimed;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class AddItem1 extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    Button btNext;
    Database databasel;
    int countItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item1);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            countItem = bd.getInt("CI");
        }

        //Ánh xạ
        databasel = new Database(this,"redimed.sqlite",null,1);
        img1 = (ImageView) findViewById(R.id.idImg1);
        img2 = (ImageView) findViewById(R.id.idImg2);
        img3 = (ImageView) findViewById(R.id.idImg3);
        img4 = (ImageView) findViewById(R.id.idImg4);
        btNext = (Button) findViewById(R.id.idBtNext);

        //code
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  =new Intent(AddItem1.this,AddItem2.class);
                it.putExtra("CI",countItem);
                startActivity(it);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,3);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,4);
            }
        });



    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1&&resultCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            img1.setImageBitmap(bitmap);
            String UrlImage = BitMapToString(bitmap);
            databasel.QueryData("CREATE TABLE IF NOT EXISTS TabelImage1(Id INTEGER PRIMARY KEY, Image VARCHAR(500))");
            Cursor itemTests = databasel.GetData("SELECT * FROM TabelImage1");
            int luu = 0;
            while (itemTests.moveToNext()){
                databasel.QueryData("UPDATE TabelImage1 SET Image ='"+ UrlImage +"' WHERE Id = 1");
                luu =1;
            }
            if(luu==0){
                databasel.QueryData("INSERT INTO TabelImage1 VALUES(1,'"+UrlImage+"')");
            }
        }
        if(requestCode==2&&resultCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            img2.setImageBitmap(bitmap);
        }
        if(requestCode==3&&resultCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            img3.setImageBitmap(bitmap);
        }
        if(requestCode==4&&resultCode==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            img4.setImageBitmap(bitmap);
        }


        super.onActivityResult(requestCode, resultCode, data);
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
