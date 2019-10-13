package com.example.users_redimed;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddItem1 extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    Button btNext;
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
}
